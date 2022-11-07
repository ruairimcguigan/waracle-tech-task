package com.waracle.techtask.repo

import com.waracle.techtask.datasource.CakesRemoteDataSource
import com.waracle.techtask.datasource.CakesRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun bindActivityRepository(impl: RepositoryImpl): Repository

    @Binds
    abstract fun bindActivityRemoteDataSource(impl: CakesRemoteDataSourceImpl): CakesRemoteDataSource
}
