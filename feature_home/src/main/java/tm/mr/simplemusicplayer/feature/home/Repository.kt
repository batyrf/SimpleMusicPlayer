package tm.mr.simplemusicplayer.feature.home

import android.content.Context
import android.util.Log
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import wseemann.media.FFmpegMediaMetadataRetriever
import javax.inject.Inject


class Repository @Inject constructor() {

    @Inject
    lateinit var api: HomeApi

    @Inject
    lateinit var context: Context

    fun getList(): Observable<List<Music>> {
        return Observable.create { emitter ->
            api.getList()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        val musics =
                            it._embedded?.items?.map { constructMusicItem(it) } ?: listOf()
                        emitter.onNext(musics)
                    },
                    {
                        Log.d("viridis", "api.getList.error: $it")
                    }
                )
        }
    }

    private fun constructMusicItem(item: Item): Music {
        return OfflineDataProvider.getMusic(context, item.name ?: "") ?: run {
            val mmr = FFmpegMediaMetadataRetriever()
            mmr.setDataSource(item.file)

            val title = mmr.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
            val duration = mmr.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION)
            val authors = mmr.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_ARTIST)
            val album = mmr.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_ALBUM)
            val year = mmr.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_CREATION_TIME)
            mmr.release()

            val music = Music(title = title, duration = duration.toLongOrNull(), authors = authors, album = album, year = year)
            OfflineDataProvider.saveMusic(context, item.name ?: "", music)
            music
        }
    }

}