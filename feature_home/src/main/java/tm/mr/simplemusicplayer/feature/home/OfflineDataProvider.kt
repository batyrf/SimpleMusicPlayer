package tm.mr.simplemusicplayer.feature.home

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import tm.mr.simplemusicplayer.library.base.extension.toData

object OfflineDataProvider {

    private const val SAVED_METADATA = "SAVED_METADATA"

    //temporary solution, will be removed after room implementation
    fun getMusic(context: Context, uri: String): Music? {
        return context.getSharedPreferences(SAVED_METADATA, Context.MODE_PRIVATE).getString(uri, null)?.toData<Music>()
    }

    fun saveMusic(context: Context, uri: String, music: Music) {
        context.getSharedPreferences(SAVED_METADATA, Context.MODE_PRIVATE).edit {
            putString(uri, Gson().toJson(music))
        }
    }

}