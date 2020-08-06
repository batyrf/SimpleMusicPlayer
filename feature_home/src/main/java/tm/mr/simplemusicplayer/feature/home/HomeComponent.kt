package tm.mr.simplemusicplayer.feature.home

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import tm.mr.simplemusicplayer.HomeModuleDependencies
import javax.inject.Singleton

@Singleton
@Component(dependencies = [HomeModuleDependencies::class], modules = [HomeModule::class])
interface HomeComponent {

    fun inject(fragment: HomeFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(homeModuleDependencies: HomeModuleDependencies): Builder
        fun build(): HomeComponent
    }

}