package com.example.audify.data.local.dao

import androidx.room.*
import com.example.audify.model.Song
import kotlinx.coroutines.flow.Flow

@Dao
interface SongsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSongs(songs: List<Song>)

    @Query("DELETE FROM ${Song.TABLE_NAME}")
    fun deleteAllSongs()

    @Query("SELECT * FROM ${Song.TABLE_NAME}")
    fun getAllSongs(): Flow<List<Song>>

    @Update
    fun updateSong(vararg song: Song)
}