package com.example.albumsapp.domain.usecases

import com.example.albumsapp.domain.model.Album
import com.example.albumsapp.domain.repository.AlbumRepository
import javax.inject.Inject


/**
 *Created by haskhiri on 17/10/2021
 */
class GetAlbumDetailUseCase @Inject constructor(private val repository: AlbumRepository)  {

    private var albumId: Long? = null

    fun saveAlbumId(id: Long) {
        albumId = id
    }

    fun getAlbumFromDb(albumId: Long): Album? {

        return repository.getAlbumDetailFromDb(albumId)
    }

}