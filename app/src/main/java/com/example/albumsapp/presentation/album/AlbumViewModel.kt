package com.example.albumsapp.presentation.album

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.albumsapp.domain.model.Album


/**
 *Created by haskhiri on 17/10/2021
 */
class AlbumViewModel(val album: Album) : ViewModel() {


    val albumData = MutableLiveData<Album>()

    init {
        albumData.value = album
    }

}