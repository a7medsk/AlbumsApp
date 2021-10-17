package com.example.albumsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.albumsapp.domain.model.Album


/**
 *Created by haskhiri on 17/10/2021
 */
@Database(entities = [Album::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val albumDao: AlbumDao

    companion object {
        const val DB_NAME = "ArtGalleryDatabase.db"
    }
}
