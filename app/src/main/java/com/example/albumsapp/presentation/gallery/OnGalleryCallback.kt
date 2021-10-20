package com.example.albumsapp.presentation.gallery

import android.widget.ImageView


/**
 *Created by haskhiri on 18/10/2021
 */
interface OnGalleryCallback {

    fun gotoDetailPageByAlbumId(imageView: ImageView, id: Int)
}