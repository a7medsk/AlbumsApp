package com.example.albumsapp.data.repository

import com.example.albumsapp.data.local.AppDatabase
import com.example.albumsapp.data.remote.RetrofitService
import com.example.albumsapp.domain.model.Album
import com.example.albumsapp.domain.repository.AlbumRepository
import io.reactivex.Observable


/**
 * This repository is responsible for
 * fetching data [album] from server or db
 * */

/**
 *Created by haskhiri on 17/10/2021
 */
class AlbumRepositoryImp(
    private val database: AppDatabase,
    private val retrofitService: RetrofitService
) : AlbumRepository {



    override fun addAlbums(albums :List<Album>) {
        database.albumDao.insertAll(*albums.toTypedArray())
    }

    override fun getAlbumDetailFromDb(albumId: Int?): Album? {

        return database.albumDao.getOneByAlbumId(albumId!!)
    }

    override fun getAlbums(): Observable<List<Album>> {

        val local =database.albumDao.loadAll().filter { it.isNotEmpty() }

        val remote = retrofitService.getAlbums().doOnNext{
            database.albumDao.insertAll(*it.toTypedArray())
        }

        return Observable.concat(local.toObservable(), remote)
            .firstElement()
            .toObservable()

    }

}