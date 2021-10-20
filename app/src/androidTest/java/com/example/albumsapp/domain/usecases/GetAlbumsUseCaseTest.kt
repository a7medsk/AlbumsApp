package com.example.albumsapp.domain.usecases

import com.example.albumsapp.data.repository.FakeAlbumRepository
import com.example.albumsapp.util.TestUtil
import org.junit.Before
import org.junit.Test


/**
 *Created by haskhiri on 20/10/2021
 */

class GetAlbumsUseCaseTest {

    private lateinit var getAlbumsUseCase: GetAlbumsUseCase
    private lateinit var fakeAlbumRepository: FakeAlbumRepository

    @Before
    fun Setup() {

        fakeAlbumRepository = FakeAlbumRepository()
        getAlbumsUseCase = GetAlbumsUseCase(fakeAlbumRepository)


    }
    @Test
    fun getAlbumsUseCaseTest(){
        val generatedListAlbum = TestUtil.generateAlbumList()
        fakeAlbumRepository.addAlbums(generatedListAlbum)

        getAlbumsUseCase.buildUseCaseObservable().test()
            .assertComplete()
            .assertNoErrors()
            .assertValue(generatedListAlbum)
    }
}