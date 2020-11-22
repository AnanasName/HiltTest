package com.example.hilttest.di

import com.example.hilttest.repository.MainRepository
import com.example.hilttest.retrofit.BlogRetrofit
import com.example.hilttest.retrofit.NetworkMapper
import com.example.hilttest.room.BlogDao
import com.example.hilttest.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
            blogDao: BlogDao,
            retrofit: BlogRetrofit,
            cacheMapper: CacheMapper,
            networkMapper: NetworkMapper
    ): MainRepository = MainRepository(
            blogDao, retrofit, cacheMapper, networkMapper)

}