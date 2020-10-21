package com.hacker.hackernewsvisualizer.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Publication Entity
 */
@Entity(tableName = "publication")
class PublicationEntity(
    @PrimaryKey
    var objectID: String,
    var title: String,
    var author: String,
    var created_at: String,
    var url: String
)