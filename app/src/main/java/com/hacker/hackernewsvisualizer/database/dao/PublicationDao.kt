package com.hacker.hackernewsvisualizer.database.dao

import androidx.room.*
import com.hacker.hackernewsvisualizer.database.entity.PublicationEntity

/**
 * Publication Dao
 */
@Dao
abstract class PublicationDao {

    @Query("SELECT * FROM publication")
    abstract suspend fun getAll(): List<PublicationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(publicationEntity: PublicationEntity)

    @Delete
    abstract suspend fun delete(publicationEntity: PublicationEntity)

    @Query("DELETE FROM publication")
    abstract suspend fun deleteAll()
}