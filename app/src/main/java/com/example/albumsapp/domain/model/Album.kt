package com.example.albumsapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 *Created by haskhiri on 17/10/2021
 */
@Entity(tableName = "Album")
data class Album(
    @PrimaryKey var id: Long,
    var title: String,
    val url: String,
    val thumbnailUrl: String?
)