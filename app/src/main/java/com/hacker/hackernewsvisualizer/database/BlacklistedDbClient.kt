package com.hacker.hackernewsvisualizer.database

import com.hacker.hackernewsvisualizer.data.model.Blacklisted
import com.hacker.hackernewsvisualizer.database.dao.BlacklistedDao
import com.hacker.hackernewsvisualizer.database.entity.BlacklistedEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Blacklisted DB client
 */
class BlacklistedDbClient(private val blacklistedDao: BlacklistedDao) : BlacklistedDb {

    override suspend fun getAll(): List<Blacklisted> {
        return withContext(Dispatchers.IO) {
            blacklistedDao.getAll()
                .map { entity -> Blacklisted(
                    objectID = entity.objectID
                ) }
        }
    }

    override suspend fun insert(objectId: String) {
        withContext(Dispatchers.IO) {
            blacklistedDao.insert(
                BlacklistedEntity(
                    objectID = objectId
            ))
        }
    }
}