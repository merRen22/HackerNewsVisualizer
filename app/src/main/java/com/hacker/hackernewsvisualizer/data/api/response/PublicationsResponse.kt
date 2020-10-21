package com.hacker.hackernewsvisualizer.data.api.response

import com.hacker.hackernewsvisualizer.data.model.Publication
import com.squareup.moshi.JsonClass

open class PublicationsResponse {
    @JsonClass(generateAdapter = true)
    var hits: Array<Publication>? = null

    fun toModel(): Any {
        return this.hits!!
    }
}