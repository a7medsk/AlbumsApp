package com.example.albumsapp.presentation.gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.albumsapp.R
import com.example.albumsapp.presentation.album.AlbumsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),OnGalleryCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigateToAlbumPage()
        }


    }

    override fun navigateToAlbumPage() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.gallery_container,
                AlbumsFragment.newInstance(),
                AlbumsFragment.FRAGMENT_NAME
            )
            .addToBackStack(AlbumsFragment.FRAGMENT_NAME)
            .commitAllowingStateLoss()
    }

    override fun gotoDetailPageByAlbumId(imageView: ImageView, id: Long) {
        TODO("Not yet implemented")
    }

}
