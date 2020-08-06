package tm.mr.simplemusicplayer.feature.home

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tm.mr.simplemusicplayer.feature.home.databinding.MusicItemLayoutBinding

class MusicsRecyclerView: RecyclerView {

    private val musicAdapter = MusicsAdapter()
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr) {
        adapter = musicAdapter
        layoutManager = LinearLayoutManager(context)
        setHasFixedSize(true)
    }

    fun setItems(items: List<Music>) {
        musicAdapter.items = items.toMutableList()
        musicAdapter.notifyDataSetChanged()
    }

}


class MusicsAdapter: RecyclerView.Adapter<MusicViewHolder>() {
    var items = mutableListOf<Music>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MusicViewHolder.create(parent)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) =
        holder.bind(items.get(position))

}

class MusicViewHolder(private val binding: MusicItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Music) {
        binding.musicItem = item
        binding.executePendingBindings()
    }

    companion object {
        fun create(parent: ViewGroup) =
            MusicViewHolder(
                MusicItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
    }

}