package com.example.audify.data.repository

import com.example.audify.data.local.dao.SongsDao
import com.example.audify.model.Song
import com.example.audify.utils.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Singleton
class SongsRepository @Inject constructor(
    private val songsDao: SongsDao
) {

    /*fun getAllSongs(): Flow<State<List<Song>>> {
        return object : NetworkBoundRepository<List<Song>, List<Song>>() {
            override suspend fun saveRemoteData(response: List<Song>) {
                TODO("Not yet implemented")
            }

            override fun fetchFromLocal(): Flow<List<Song>> {
                return songsDao.getAllSongs()
            }

            override suspend fun fetchFromRemote(): Response<List<Song>> {
                return audifyService.getSongs()
            }

        }.asFlow().flowOn(Dispatchers.IO)
    }*/
}