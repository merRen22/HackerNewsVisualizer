package com.hacker.hackernewsvisualizer.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hacker.hackernewsvisualizer.database.entity.BlacklistedEntity

/**
 * Blacklisted Dao
 */
@Dao
abstract class BlacklistedDao {

    @Query("SELECT * FROM blacklisted")
    abstract suspend fun getAll(): List<BlacklistedEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(blacklistedEntity: BlacklistedEntity)

}