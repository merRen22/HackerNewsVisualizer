package com.hacker.hackernewsvisualizer.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hacker.hackernewsvisualizer.database.dao.BlacklistedDao
import com.hacker.hackernewsvisualizer.database.dao.PublicationDao
import com.hacker.hackernewsvisualizer.database.entity.BlacklistedEntity
import com.hacker.hackernewsvisualizer.database.entity.PublicationEntity

/**
 * App Database
 */
@Database(entities = [PublicationEntity::class, BlacklistedEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val publicationDao: PublicationDao

    abstract val blacklistedDao: BlacklistedDao
}