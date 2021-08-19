package com.example.audify.ui.main

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.audify.data.repository.SongsRepository
import com.example.audify.model.Song
import com.example.audify.utils.State
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject


@ExperimentalCoroutinesApi
class SongViewModel @Inject constructor(private val repository: SongsRepository) : ViewModel() {

    private val _songsLiveData = MutableLiveData<State<List<Song>>>()

    val songsLiveData: LiveData<State<List<Song>>>
        get() = _songsLiveData

    fun getSongs() {
        viewModelScope.launch {

        }
    }

    /*fun getPlayList(): ArrayList<HashMap<String, String>>? {
        val fileList: ArrayList<HashMap<String, String>> = ArrayList()
        return try {
            val rootFolder = File(Environment.getExternalStorageDirectory().absolutePath)
            val files: Array<File> =
                rootFolder.listFiles() //here you will get NPE if directory doesn't contains  any file,handle it like this.
            for (file in files) {
                if (file.isDirectory) {
                    if (getPlayList(file.absolutePath) != null) {
                        fileList.addAll(getPlayList(file.absolutePath)!!)
                    } else {
                        break
                    }
                } else if (file.name.endsWith(".mp3")) {
                    val song: HashMap<String, String> = HashMap()
                    song["file_path"] = file.absolutePath
                    song["file_name"] = file.name
                    fileList.add(song)
                }
            }
            fileList
        } catch (e: Exception) {
            null
        }
    }*/


    // this should be singleton, context should not be passed in viewmodel
    fun getAllAudioFromDevice(context: Context): List<Song> {
        val tempAudioList: MutableList<Song> = ArrayList()
        val uri: Uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Audio.AudioColumns.DATA,
            MediaStore.Audio.AudioColumns.TITLE,
            MediaStore.Audio.AudioColumns.ALBUM,
            MediaStore.Audio.ArtistColumns.ARTIST
        )
        val c: Cursor? = context.contentResolver.query(
            uri,
            projection,
            MediaStore.Audio.Media.DATA + " like ? ",
            arrayOf("%utm%"),
            null
        )
        if (c != null) {
            while (c.moveToNext()) {
                // Create a model object.
                val audioModel = Song()
                val path: String = c.getString(0) // Retrieve path.
                val name: String = c.getString(1) // Retrieve name.
                val album: String = c.getString(2) // Retrieve album name.
                val artist: String = c.getString(3) // Retrieve artist name.

                // Set data to the model object.
                audioModel.name = name
                audioModel.album = album
                audioModel.artist = artist
                audioModel.path = path
                Log.e("Name :$name", " Album :$album")
                Log.e("Path :$path", " Artist :$artist")

                // Add the model object to the list .
                tempAudioList.add(audioModel)
            }
            c.close()
        }

        // Return the list.
        return tempAudioList
    }
}