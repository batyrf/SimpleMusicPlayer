package tm.mr.simplemusicplayer.feature.home

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface HomeApi {

    @Headers("Authorization: OAuth AgAAAABD2DTaAADLW0j9eAfVX0EAubOkMmhODOQ")
    @GET("disk/resources")
    fun getList(@Query("path") path: String = "mp3"): Observable<Response>

}