package com.example.albumsapp.presentation.album

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.albumsapp.domain.model.Album


/**
 *Created by haskhiri on 17/10/2021
 */
class AlbumViewModel(val album: Album) : ViewModel() {

    private val TAG = AlbumViewModel::class.java.name
    val albumData = MutableLiveData<Album>()

    init {
        albumData.value = album
    }

}