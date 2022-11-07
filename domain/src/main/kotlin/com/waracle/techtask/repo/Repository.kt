package com.waracle.techtask.repo

interface Repository {
    suspend fun fetchCakes(): com.waracle.techtask.model.Result<List<com.waracle.techtask.model.CakeItemDomain>>
}
