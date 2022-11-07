package com.waracle.techtask.repo

import com.waracle.techtask.models.CakesItem
import com.waracle.techtask.models.Result

interface Repository {
    suspend fun fetchCakes(): Result<List<CakesItem>>
}