package com.example.albumsapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.albumsapp.domain.model.Album
import io.reactivex.Maybe


/**
 *Created by haskhiri on 17/10/2021
 */
@Dao
interface AlbumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg albums: Album)

    @Query("SELECT * FROM Album")
    fun loadAll(): Maybe<List<Album>>

    @Query("SELECT * FROM Album where id = :albumId")
    fun getOneByAlbumId(albumId: Long): Album?




}