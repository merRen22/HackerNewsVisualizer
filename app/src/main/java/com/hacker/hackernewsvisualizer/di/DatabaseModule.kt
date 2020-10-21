package com.hacker.hackernewsvisualizer.di

import android.app.Application
import androidx.room.Room
import com.hacker.hackernewsvisualizer.database.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Database Module
 * Define all the database-related classes that need to be provided in the scope of Application.
 */
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "publicationsdb").build()
    }

    @Provides
    @Singleton
    fun providePublicationDb(appDatabase: AppDatabase): PublicationDb {
        return PublicationDbClient(appDatabase.publicationDao)
    }

    @Provides
    @Singleton
    fun provideBlacklistedDb(appDatabase: AppDatabase): BlacklistedDb {
        return BlacklistedDbClient(appDatabase.blacklistedDao)
    }
}