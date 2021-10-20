package com.example.albumsapp.util

import com.example.albumsapp.domain.model.Album


/**
 *Created by haskhiri on 18/10/2021
 */

class TestUtil {

    companion object {
        fun getTestAlbum(id: Int): Album {
            return Album(
                id = id,
                title = "Album$id",
                url = "",
                thumbnailUrl = ""
            )
        }


        fun generateAlbumList(): List<Album> {
            return (0..5).map { getTestAlbum(it) }
        }
    }

}