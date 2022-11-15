package com.waracle.techtask.di

import com.waracle.techtask.datasource.CakesRemoteDataSource
import com.waracle.techtask.datasource.CakesRemoteDataSourceImpl
import com.waracle.techtask.repo.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.waracle.techtask.repository.RepositoryImpl

@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(impl: RepositoryImpl): Repository

    @Binds
    abstract fun bindRemoteDataSource(impl: CakesRemoteDataSourceImpl): CakesRemoteDataSource

}
