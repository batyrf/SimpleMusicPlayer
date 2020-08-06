package tm.mr.simplemusicplayer.feature.home

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object HomeModule {

    @Provides
    fun provideHomeApi(retrofit: Retrofit): HomeApi =
        retrofit.create(HomeApi::class.java)

}