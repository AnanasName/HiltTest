package com.example.hilttest.di

import android.content.Context
import androidx.room.Room
import com.example.hilttest.room.BlogDao
import com.example.hilttest.room.BlogDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideBlogDb(@ApplicationContext context: Context): BlogDatabase =
            Room.databaseBuilder(context,
                    BlogDatabase::class.java,
                    BlogDatabase.DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build()

    @Singleton
    @Provides
    fun provideBlogDAO(blogDatabase: BlogDatabase): BlogDao =
            blogDatabase.blogDao()


}