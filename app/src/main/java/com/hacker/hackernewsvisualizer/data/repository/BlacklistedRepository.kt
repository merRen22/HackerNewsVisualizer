package com.hacker.hackernewsvisualizer.data.repository

import com.hacker.hackernewsvisualizer.data.api.PublicationsApi
import com.hacker.hackernewsvisualizer.data.model.Blacklisted
import com.hacker.hackernewsvisualizer.data.model.Publication
import com.hacker.hackernewsvisualizer.database.BlacklistedDb
import com.hacker.hackernewsvisualizer.database.PublicationDb
import javax.inject.Inject

class BlacklistedRepository @Inject constructor(
    private val blacklistedDb: BlacklistedDb
) {
    suspend fun getLocalPublications(): List<Blacklisted> {
        return blacklistedDb.getAll()
    }

    suspend fun insertToLocal(objectId: String) {
        return blacklistedDb.insert(objectId)
    }
}