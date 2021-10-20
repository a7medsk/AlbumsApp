package com.example.albumsapp.presentation.album

import android.widget.ImageView


/**
 *Created by haskhiri on 17/10/2021
 */
interface OnAlbumAdapterListener{

    fun gotoDetailPage(imageView: ImageView, id: Int)

}