package com.example.albumsapp.domain.usecases

import com.example.albumsapp.data.repository.FakeAlbumRepository
import com.example.albumsapp.util.TestUtil
import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Created by haskhiri on 20/10/2021
 */
class GetAlbumDetailUseCaseTest{

    private lateinit var getAlbumDetailUseCase: GetAlbumDetailUseCase
    private lateinit var fakeAlbumRepository: FakeAlbumRepository

    @Before
    fun Setup() {

        fakeAlbumRepository = FakeAlbumRepository()
        getAlbumDetailUseCase = GetAlbumDetailUseCase(fakeAlbumRepository)


    }
    @Test
    fun getAlbumsUseCaseTest(){
        val generatedAlbum = TestUtil.getTestAlbum(5)
        fakeAlbumRepository.addAlbum(generatedAlbum)

        val expectedAlbum = getAlbumDetailUseCase.getAlbumFromDb(5)

        assertThat(generatedAlbum, CoreMatchers.equalTo(expectedAlbum))
    }
}

