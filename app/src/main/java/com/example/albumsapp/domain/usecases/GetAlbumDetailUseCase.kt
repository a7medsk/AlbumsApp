package com.example.albumsapp.domain.usecases

import com.example.albumsapp.domain.model.Album
import com.example.albumsapp.domain.repository.AlbumRepository
import javax.inject.Inject


/**
 *Created by haskhiri on 17/10/2021
 */
class GetAlbumDetailUseCase @Inject constructor(private val repository: AlbumRepository)  {

    private var albumId: Int? = null

    fun saveAlbumId(id: Int) {
        albumId = id
    }

    fun getAlbumFromDb(albumId: Int): Album? {

        return repository.getAlbumDetailFromDb(albumId)
    }

}