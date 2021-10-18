package com.example.albumsapp.presentation.detailalbum

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.albumsapp.domain.model.Album
import com.example.albumsapp.domain.usecases.GetAlbumDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 *Created by haskhiri on 18/10/2021
 */
@HiltViewModel
class AlbumDetailViewModel@Inject constructor(private val getAlbumDetailUseCase: GetAlbumDetailUseCase) : ViewModel() {

    val albumData = MutableLiveData<Album>()
    val isLoad = MutableLiveData<Boolean>()

    init {
        isLoad.value = false
    }



    fun getDetailFromDb(id: Long?){
        if (id == null) return
        getAlbumDetailUseCase.saveAlbumId(id)
        albumData.value = getAlbumDetailUseCase.getAlbumFromDb(id)
    }


}