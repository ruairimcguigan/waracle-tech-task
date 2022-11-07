package com.waracle.techtask.datasource

import com.waracle.techtask.api.CakesApi
import com.waracle.techtask.model.CakeItemDomain
import com.waracle.techtask.model.Result
import com.waracle.techtask.model.runCatching
import javax.inject.Inject

class CakesRemoteDataSourceImpl @Inject constructor(private val api: CakesApi) :
    CakesRemoteDataSource {

    override suspend fun fetchCakes(): Result<List<CakeItemDomain>> = runCatching { api.getCakes() }
}
