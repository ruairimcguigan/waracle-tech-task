package com.waracle.techtask.interactors

import com.waracle.techtask.models.CakesItem
import com.waracle.techtask.models.Result

interface GetCakesInteractor {
    suspend operator fun invoke(): Result<List<CakesItem>>
}
