package com.waracle.techtask.interactors

import com.waracle.techtask.model.CakeItemDomain
import com.waracle.techtask.model.Result

interface GetCakesInteractor {
    suspend operator fun invoke(): Result<List<CakeItemDomain>>
}
