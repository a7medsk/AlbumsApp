package com.example.albumsapp.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.albumsapp.domain.model.Album
import com.example.albumsapp.util.TestUtil
import org.junit.Assert.*
import org.hamcrest.CoreMatchers.equalTo

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


/**
 *Created by haskhiri on 18/10/2021
 */

@RunWith(AndroidJUnit4ClassRunner::class)
class AlbumDaoTest {

    private lateinit var mDatabase: AppDatabase

    // TODO: 19/10/2021 Add hilt dagger injection
    @Before
    fun createDb() {
        mDatabase = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), AppDatabase::class.java)
            .build()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        mDatabase.close()
    }



    @Test
    @Throws(Exception::class)
    fun findAlbumById(){
        val album=TestUtil.getTestAlbum(1)
        mDatabase.albumDao.insert(album)
        val expectedAlbum = mDatabase.albumDao.getOneByAlbumId(album.id)
        assertThat(album,equalTo(expectedAlbum) )

    }

    @Test
    @Throws(Exception::class)
    fun retrievesPhotos(){
        val albumList = TestUtil.generateAlbumList()
        mDatabase.albumDao.insertAll(*albumList.toTypedArray())
        val testObserver = mDatabase.albumDao.loadAll().test()
        testObserver
            .assertComplete()
            .assertNoErrors()
            .assertValue(albumList)

    }

}