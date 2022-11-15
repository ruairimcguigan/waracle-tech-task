package com.waracle.techtask.datasource

import com.waracle.techtask.model.CakeItemDomain
import com.waracle.techtask.model.Result

interface CakesRemoteDataSource {
    suspend fun fetchCakes(): Result<List<CakeItemDomain>>
}
