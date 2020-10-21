package com.hacker.hackernewsvisualizer.database

import com.hacker.hackernewsvisualizer.data.model.Publication
import com.hacker.hackernewsvisualizer.database.dao.PublicationDao
import com.hacker.hackernewsvisualizer.database.entity.PublicationEntity
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

/**
 * Publication DB client
 */
class PublicationDbClient(private val publicationDao: PublicationDao) : PublicationDb {

    override suspend fun getAll(): List<Publication> {
        return withContext(IO) {
            publicationDao.getAll()
                .map { entity -> Publication(
                    objectID = entity.objectID,
                    title = entity.title,
                    author = entity.author,
                    created_at = entity.created_at,
                    url = entity.url
                ) }
        }
    }

    override suspend fun insert(publication: Publication) {
        withContext(IO) {
            publicationDao.insert(PublicationEntity(
                objectID = publication.objectID!!,
                title = publication.title?:publication.story_title!!,
                author = publication.author!!,
                url = publication.url?:publication.story_url!!,
                created_at = publication.created_at!!))
        }
    }

    override suspend fun delete(publication: Publication) {
        withContext(IO) {
            publicationDao.delete(
                PublicationEntity(
                    objectID = publication.objectID!!,
                    title = publication.title?:publication.story_title!!,
                    author = publication.author!!,
                    url = publication.url?:publication.story_url!!,
                    created_at = publication.created_at!!)
            )
        }
    }

    override suspend fun deleteAll() {
        withContext(IO) {
            publicationDao.deleteAll()
        }
    }
}