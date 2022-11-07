package com.waracle.techtask.datasource

import com.waracle.techtask.models.CakesItem
import com.waracle.techtask.models.Result

interface CakesRemoteDataSource {
    suspend fun fetchCakes(): Result<List<CakesItem>>
}
