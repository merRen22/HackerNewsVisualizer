package com.hacker.hackernewsvisualizer.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Blacklisted Entity
 */
@Entity(tableName = "blacklisted")
class BlacklistedEntity(
    @PrimaryKey
    var objectID: String
)