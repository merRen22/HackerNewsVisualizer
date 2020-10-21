package com.hacker.hackernewsvisualizer.data.repository

import com.hacker.hackernewsvisualizer.data.api.PublicationsApi
import com.hacker.hackernewsvisualizer.data.api.Result
import com.hacker.hackernewsvisualizer.data.model.Publication
import com.hacker.hackernewsvisualizer.database.PublicationDb
import javax.inject.Inject

class PublicationsRepository @Inject constructor(
    private val publicationsApi: PublicationsApi,
    private val publicationsDb: PublicationDb
) {

    suspend fun getPublications(): Result<Array<Publication>> {
        return publicationsApi.getPublications()
    }

    suspend fun getLocalPublications(): List<Publication> {
        return publicationsDb.getAll()
    }

    suspend fun removeLocal(publication: Publication) {
        return publicationsDb.delete(publication)
    }

    suspend fun removeAllLocal() {
        return publicationsDb.deleteAll()
    }

    suspend fun insertToLocal(publication: Publication) {
        return publicationsDb.insert(publication)
    }
}