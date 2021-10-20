package com.example.albumsapp.domain.repository

import com.example.albumsapp.domain.model.Album
import io.reactivex.Observable


/**
 * * To make an interaction between [AlbulRepositoryImp] & [GetAlbumsUseCase]
 *
 *Created by haskhiri on 17/10/2021
 */
interface AlbumRepository {

    fun getAlbums(): Observable<List<Album>>

    fun getAlbumDetailFromDb(albumId: Int?): Album?

    fun addAlbums(albums: List<Album>)
}