package com.hacker.hackernewsvisualizer.data.model

data class Publication(
    var objectID: String?=null,
    var story_title: String?=null,
    var title: String?=null,
    var author: String?=null,
    var created_at: String?=null,
    var url: String?=null,
    var story_url: String?=null
)

data class PublicationsResult(
    val successPublications: List<Publication>? = null,
    val errorPublications: Int? = null
)