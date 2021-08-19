package com.example.audify.data.remote

import com.example.audify.model.Song
import retrofit2.Response

interface AudifyService {
    fun getSongs(): Response<List<Song>>
}