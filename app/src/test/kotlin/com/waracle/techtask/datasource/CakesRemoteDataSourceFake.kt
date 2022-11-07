package com.waracle.techtask.datasource

import com.waracle.techtask.models.CakesItem
import com.waracle.techtask.models.Result

class CakesRemoteDataSourceFake : CakesRemoteDataSource {

    var getCakesWasCalled = false
        private set

    override suspend fun fetchCakes(): Result<List<CakesItem>> {
        getCakesWasCalled = true
        return Result.Success(listOf(firstCake, secondCake))
    }
}
