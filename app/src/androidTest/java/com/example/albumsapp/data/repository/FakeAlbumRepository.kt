package com.example.albumsapp.data.repository

import com.example.albumsapp.domain.model.Album
import com.example.albumsapp.domain.repository.AlbumRepository
import io.reactivex.Observable
import java.util.*
import kotlin.collections.LinkedHashMap


/**
 *Created by haskhiri on 20/10/2021
 */
class FakeAlbumRepository :AlbumRepository {

    private val albums: LinkedHashMap<Int, Album> = LinkedHashMap()

    override fun getAlbums(): Observable<List<Album>> {
        return Observable.just(albums.values.toList())
    }

    override fun getAlbumDetailFromDb(albumId: Int?): Album? {
        return albums[albumId!!]
    }

    override fun addAlbums(albums: List<Album>) {
        albums.forEach { album -> this.albums[album.id] = album }
    }

    fun addAlbum(album:Album?) {
        albums[album!!.id] = album
    }
}