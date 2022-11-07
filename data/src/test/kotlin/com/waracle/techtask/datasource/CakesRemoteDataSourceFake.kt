package com.waracle.techtask.datasource

import com.waracle.techtask.model.CakeItemDomain
import com.waracle.techtask.model.Result

class CakesRemoteDataSourceFake : CakesRemoteDataSource {

    var getCakesWasCalled = false
        private set

    override suspend fun fetchCakes(): Result<List<CakeItemDomain>> {
        getCakesWasCalled = true
        return Result.Success(listOf(firstCake, secondCake))
    }
}
