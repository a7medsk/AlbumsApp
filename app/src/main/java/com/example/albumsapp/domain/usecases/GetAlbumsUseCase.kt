package com.example.albumsapp.domain.usecases

import com.example.albumsapp.domain.model.Album
import com.example.albumsapp.domain.repository.AlbumRepository
import com.example.albumsapp.domain.usecases.base.ObservableUseCase
import io.reactivex.Observable
import javax.inject.Inject


/**
 *Created by haskhiri on 17/10/2021
 */
class GetAlbumsUseCase @Inject constructor(private val repository: AlbumRepository) : ObservableUseCase<List<Album>>() {

    private var albumId: Long? = null

    fun saveAlbumId(id: Long) {
        albumId = id
    }


    override fun buildUseCaseObservable(): Observable<List<Album>> {

        return repository.getAlbums()
    }
}