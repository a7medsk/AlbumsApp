package com.example.albumsapp.data.repository

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.albumsapp.data.local.AppDatabase
import com.example.albumsapp.data.remote.RetrofitService
import com.example.albumsapp.domain.repository.AlbumRepository
import com.example.albumsapp.util.TestUtil
import com.example.albumsapp.util.TestUtil.Companion.generateAlbumList
import io.reactivex.Observable
import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import org.mockito.Mockito.*

/**
 * Created by haskhiri on 19/10/2021
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class AlbumRepositoryImpTest {

    private lateinit var retrofitService: RetrofitService
    private lateinit var mDatabase: AppDatabase
    private lateinit var albumRepository: AlbumRepository

    @Before
    fun setup() {
        retrofitService = mock(RetrofitService::class.java)
        mDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        )
            .build()

        albumRepository = AlbumRepositoryImp(mDatabase, retrofitService)


    }

    @Test
    fun testAddAlbum() {
        val generatedListAlbum = generateAlbumList()
        mDatabase.albumDao.insertAll(*generatedListAlbum.toTypedArray())
        `when`(retrofitService.getAlbums()).thenReturn(Observable.just(generatedListAlbum))

        albumRepository.getAlbums().test()
            .assertComplete()
            .assertNoErrors()
            .assertValue(generatedListAlbum)
    }

    @Test
    fun testGetAlbumByIdReturnedApiAlbum() {
        val generatedAlbum = TestUtil.getTestAlbum(5)
        mDatabase.albumDao.insert(generatedAlbum)
        val expectedAlbum= albumRepository.getAlbumDetailFromDb(5)

        assertThat(generatedAlbum, CoreMatchers.equalTo(expectedAlbum))
    }


}