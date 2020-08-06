package tm.mr.simplemusicplayer.library.base.extension

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> String.toData(): T? {
    return try {
        Gson().fromJson<T>(this, object : TypeToken<T>() {}.type)
    } catch (e: Exception) {
        null
    }
}