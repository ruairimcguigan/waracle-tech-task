package com.waracle.techtask.datasource

import com.waracle.techtask.api.CakesApi
import com.waracle.techtask.models.CakesItem
import com.waracle.techtask.models.Result
import com.waracle.techtask.models.runCatching
import javax.inject.Inject

class CakesRemoteDataSourceImpl @Inject constructor(private val api: CakesApi) :
    CakesRemoteDataSource {
    override suspend fun fetchCakes(): Result<List<CakesItem>> = runCatching { api.getCakes() }
}
