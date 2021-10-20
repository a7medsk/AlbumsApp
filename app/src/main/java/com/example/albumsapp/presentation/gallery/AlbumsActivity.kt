package com.example.albumsapp.presentation.gallery

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.albumsapp.R
import com.example.albumsapp.presentation.album.AlbumsFragment
import com.example.albumsapp.presentation.detailalbum.AlbumDetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumsActivity : AppCompatActivity(),OnGalleryCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)
    }



    override fun gotoDetailPageByAlbumId(imageView: ImageView, id: Int) {

        val intent = Intent(this, AlbumDetailActivity::class.java)
        val bundle = Bundle().apply {
            putInt(KEY_PHOTO_ID, id)
        }
        intent.putExtras(bundle)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this,
            imageView,
            ViewCompat.getTransitionName(imageView) ?: ""
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, options.toBundle())
        } else {
            startActivity(intent)
        }
    }

    companion object {
        private val KEY_PHOTO_ID = "KEY_PHOTO_ID"
    }

}
