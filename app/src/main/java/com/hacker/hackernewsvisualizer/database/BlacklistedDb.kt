package com.hacker.hackernewsvisualizer.database

import com.hacker.hackernewsvisualizer.data.model.Blacklisted

/**
 * Blacklisted DB
 */
interface BlacklistedDb {

    /**
     * get all [Blacklisted]
     */
    suspend fun getAll(): List<Blacklisted>

    /**
     * delete [Blacklisted]
     */
    suspend fun insert(objectId: String)

}