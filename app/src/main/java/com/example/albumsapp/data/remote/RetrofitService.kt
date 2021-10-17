package com.example.albumsapp.data.remote

import com.example.albumsapp.domain.model.Album
import io.reactivex.Observable
import retrofit2.http.GET


/**
 *Created by haskhiri on 17/10/2021
 */
    interface RetrofitService {
        @GET("img/shared/technical-test.json")
        fun getAlbums(): Observable<List<Album>>
    }
