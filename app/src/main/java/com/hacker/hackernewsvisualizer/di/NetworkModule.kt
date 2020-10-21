package com.hacker.hackernewsvisualizer.di

import com.hacker.hackernewsvisualizer.Config
import com.hacker.hackernewsvisualizer.data.api.PublicationsApi
import com.hacker.hackernewsvisualizer.data.api.PublicationsDataSource
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Network Module
 * Define all the network-related classes that need to be provided in the scope of Application.
 */
@Module
open class NetworkModule {

    @Provides
    @Singleton
    open fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10L, TimeUnit.SECONDS)
            .writeTimeout(10L, TimeUnit.SECONDS)
            .readTimeout(30L, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Config.API_ENDPOINT)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providePublicationsApi(retrofit: Retrofit): PublicationsApi {
        return PublicationsDataSource(retrofit)
    }


}