package com.waracle.techtask.interactors

import com.waracle.techtask.model.CakeItemDomain
import com.waracle.techtask.model.Result
import com.waracle.techtask.repo.Repository
import javax.inject.Inject

class GetCakesInteractorImpl @Inject constructor(
    private val repo: Repository
) : GetCakesInteractor {

    override suspend fun invoke(): Result<List<CakeItemDomain>> = repo.fetchCakes()
}
