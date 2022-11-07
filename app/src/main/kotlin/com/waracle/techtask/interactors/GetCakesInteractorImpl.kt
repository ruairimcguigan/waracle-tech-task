package com.waracle.techtask.interactors

import com.waracle.techtask.models.CakesItem
import com.waracle.techtask.models.Result
import com.waracle.techtask.repo.Repository
import javax.inject.Inject

class GetCakesInteractorImpl @Inject constructor(
    private val repo: Repository
) : GetCakesInteractor {

    override suspend fun invoke(): Result<List<CakesItem>> = repo.fetchCakes()
}
