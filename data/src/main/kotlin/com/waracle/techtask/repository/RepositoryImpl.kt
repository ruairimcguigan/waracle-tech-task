package com.waracle.techtask.repository

import com.waracle.techtask.datasource.CakesRemoteDataSource
import com.waracle.techtask.repo.Repository
import com.waracle.techtask.annotation.AppScope
import com.waracle.techtask.annotation.IODispatcher
import com.waracle.techtask.model.CakeItemDomain
import com.waracle.techtask.model.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    @AppScope private val appScope: CoroutineScope,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
    private val remoteDataSource: CakesRemoteDataSource
) : Repository {

    override suspend fun fetchCakes(): Result<List<CakeItemDomain>> {
        return withContext(ioDispatcher) {
            remoteDataSource.fetchCakes()
        }
    }
}
