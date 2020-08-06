package tm.mr.simplemusicplayer.feature.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Music(
    val art: String? = null,
    val title: String? = null,
    val duration: Long? = null,
    val authors: String? = null,
    val album: String? = null,
    val year: String? = null
): Parcelable