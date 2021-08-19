package com.example.audify.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.audify.R
import com.example.audify.databinding.ActivityMainBinding
import com.example.audify.model.Song
import com.example.audify.ui.base.BaseActivity
import com.example.audify.ui.main.adapter.SongsListAdapter
import com.example.audify.utils.viewModelOf
import java.io.File

class MainActivity :BaseActivity<SongViewModel, ActivityMainBinding>(), SongsListAdapter.OnItemClickListener {

    private val mAdapter: SongsListAdapter by lazy { SongsListAdapter(onItemClickListener = this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewBinding.songRV.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mAdapter
        }

        initSongs()
    }

    private fun initSongs() {
        val playList = mViewModel.getAllAudioFromDevice(this)

        playList.forEach {
            val name = it.name
            val path = it.path

            Log.d("song", name)
        }


    }

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun getViewModel() = viewModelOf<SongViewModel>(mViewModelProvider)

    override fun onItemClicked(song: Song, view: View) {
        TODO("Not yet implemented")
    }


}