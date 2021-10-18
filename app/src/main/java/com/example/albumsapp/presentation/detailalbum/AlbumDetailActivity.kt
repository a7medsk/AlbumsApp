package com.example.albumsapp.presentation.detailalbum

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.albumsapp.R
import com.example.albumsapp.databinding.ActivityAlbumDetailBinding
import com.example.albumsapp.presentation.loadImageFull
import dagger.hilt.android.AndroidEntryPoint


/**
 *Created by haskhiri on 18/10/2021
 */
@AndroidEntryPoint
class AlbumDetailActivity :AppCompatActivity(){

    private lateinit var activityAlbumDetailBinding: ActivityAlbumDetailBinding
    private val viewModel: AlbumDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityAlbumDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_album_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activityAlbumDetailBinding.albumDetailViewModel = viewModel

        val photoId = intent?.extras?.getLong(KEY_PHOTO_ID) ?: return
        viewModel.getDetailFromDb(photoId)
        // viewModel.checkFavoriteStatus(photoId)

        viewModel.albumData.observe(this, Observer {
            activityAlbumDetailBinding.detailTitleTextView.text = it?.title
            activityAlbumDetailBinding.detailToolbarImageView.loadImageFull(it?.url)
        })


    }
    companion object {
        private val KEY_PHOTO_ID = "KEY_PHOTO_ID"
    }
}