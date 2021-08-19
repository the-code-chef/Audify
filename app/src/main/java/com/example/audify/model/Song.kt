package com.example.audify.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.audify.model.Song.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Song(
    @PrimaryKey var id: Int = 0,
    var name: String = "",
    var isFav: Boolean = false,
    var artist: String = "",
    var album: String = "",
    var path: String = ""

) {
    companion object {
        const val TABLE_NAME = "AudifySongs"
    }
}
