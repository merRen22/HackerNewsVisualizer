package com.hacker.hackernewsvisualizer.data.api

import com.hacker.hackernewsvisualizer.data.api.response.PublicationsResponse
import com.hacker.hackernewsvisualizer.data.model.Publication
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.http.GET
import java.io.IOException

/**
 * Class that handles publications.
 */

class PublicationsDataSource(retrofit: Retrofit): PublicationsApi {

    //region Services
    interface Service {
        @GET("search_by_date?query=android")
        suspend fun getPublications(): PublicationsResponse
    }

    private val service = retrofit.create(Service::class.java)

        override suspend fun getPublications(): Result<Array<Publication>> {
        return withContext(IO) {
            try {
                val serviess = service.getPublications()
                Result.Success(serviess.toModel() as Array<Publication>)
            } catch (e: Throwable) {
                Result.Error(
                    IOException(
                        "Error logging in",
                        e
                    )
                )
            }
        }
    }
}