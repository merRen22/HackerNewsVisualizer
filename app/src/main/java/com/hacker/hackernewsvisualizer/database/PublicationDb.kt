package com.hacker.hackernewsvisualizer.database

import com.hacker.hackernewsvisualizer.data.model.Publication

/**
 * Publication DB
 */
interface PublicationDb {

    /**
     * get all [Publication]
     */
    suspend fun getAll(): List<Publication>

    /**
     * insert [Publication]
     */
    suspend fun insert(publication: Publication)

    /**
     * delete [Publication]
     */
    suspend fun delete(publication: Publication)

    /**
     * delete all [Publication]
     */
    suspend fun deleteAll()
}