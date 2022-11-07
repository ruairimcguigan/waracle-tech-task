package com.waracle.techtask.repo

import com.waracle.techtask.annotation.AppScope
import com.waracle.techtask.annotation.IODispatcher
import com.waracle.techtask.datasource.CakesRemoteDataSource
import com.waracle.techtask.models.CakesItem
import com.waracle.techtask.models.Result
import kotlinx.coroutines.*
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    @AppScope private val appScope: CoroutineScope,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
    private val remoteDataSource: CakesRemoteDataSource
) : Repository {

    override suspend fun fetchCakes(): Result<List<CakesItem>> {
        return withContext(ioDispatcher) {
            remoteDataSource.fetchCakes()
        }
    }
}
