package tm.mr.simplemusicplayer

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface HomeModuleDependencies {

    fun retrofit(): Retrofit

}