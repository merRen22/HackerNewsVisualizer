package com.hacker.hackernewsvisualizer.data.api

import com.hacker.hackernewsvisualizer.data.model.Publication

interface PublicationsApi {

    /**
     * publications
     */
    suspend fun getPublications(): Result<Array<Publication>>
}