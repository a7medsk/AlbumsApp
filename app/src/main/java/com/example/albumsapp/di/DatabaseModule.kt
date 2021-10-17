package com.example.albumsapp.di

import android.app.Application
import androidx.room.Room
import com.example.albumsapp.data.local.AlbumDao
import com.example.albumsapp.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 *Created by haskhiri on 17/10/2021
 */
@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    internal fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        ).allowMainThreadQueries().build()
    }


    @Provides
    internal fun provideAlbumDao(appDatabase: AppDatabase): AlbumDao {
        return appDatabase.albumDao
    }
}