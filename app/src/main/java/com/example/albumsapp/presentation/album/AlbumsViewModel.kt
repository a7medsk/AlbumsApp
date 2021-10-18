package com.example.albumsapp.presentation.album

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.albumsapp.domain.model.Album
import com.example.albumsapp.domain.usecases.GetAlbumsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 *Created by haskhiri on 17/10/2021
 */
@HiltViewModel
class AlbumsViewModel @Inject constructor(private val getAlbumsUseCase: GetAlbumsUseCase) : ViewModel() {


     val albumListReceivedLiveData = MutableLiveData<List<Album>>()
     val isLoad = MutableLiveData<Boolean>()

    init {
        isLoad.value = false
    }


    fun getAlbums() {

        getAlbumsUseCase.execute(
            onSuccess = {
                isLoad.value = true
                albumListReceivedLiveData.value = it
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
}