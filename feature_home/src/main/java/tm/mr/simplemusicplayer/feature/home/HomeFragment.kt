package tm.mr.simplemusicplayer.feature.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*
import tm.mr.simplemusicplayer.HomeModuleDependencies
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    @Inject
    lateinit var api: HomeApi

    @Inject
    lateinit var repository: Repository

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        DaggerHomeComponent.builder()
            .context(this.requireContext())
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    this.requireActivity().applicationContext,
                    HomeModuleDependencies::class.java
                )
            ).build()
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("viridis", "SimpleMusicPlayer.onViewCreated")


        repository.getList()
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    it.map { Log.d("viridis", "getList.item: $it") }
                    this.activity?.runOnUiThread { rvMusics.setItems(it) }
                },
                {
                    Log.d("viridis", "getList.error: $it")
                }
            )
            .addTo(CompositeDisposable())
    }

}