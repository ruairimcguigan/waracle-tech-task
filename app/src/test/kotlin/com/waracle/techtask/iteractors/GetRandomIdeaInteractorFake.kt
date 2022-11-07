package com.waracle.techtask.iteractors

import com.waracle.techtask.datasource.*
import com.waracle.techtask.interactors.GetCakesInteractor
import com.waracle.techtask.models.CakesItem
import com.waracle.techtask.models.Result

class GetCakesInteractorFake(
    private val isSuccessful: Boolean = true
) : GetCakesInteractor {

    var cakes: List<CakesItem>? = null

    override suspend fun invoke(): Result<List<CakesItem>> {
        return if (isSuccessful) Result.Success(
            cakes ?: listOf(
                secondCake,
                fifthCake,
                thirdCake,
                fifthCake,
                thirdCake,
                fifthCake,
                thirdCake,
                firstCake,
                fourthCake,
                sixthCake
            )
        )
        else Result.Error(RuntimeException("merde"))
    }
}
