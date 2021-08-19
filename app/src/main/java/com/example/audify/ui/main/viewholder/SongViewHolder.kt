package com.example.audify.ui.main.viewholder

import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.audify.databinding.SongItemBinding
import com.example.audify.model.Song
import com.example.audify.ui.main.adapter.SongsListAdapter

class SongViewHolder(private val songItemBinding: SongItemBinding) :
    RecyclerView.ViewHolder(songItemBinding.root) {

    fun bind(song: Song, onItemClickListener: SongsListAdapter.OnItemClickListener? = null) {

        onItemClickListener?.let { listener ->
            songItemBinding.root.setOnClickListener {
                listener.onItemClicked(song, songItemBinding.image)
            }
        }
    }
}