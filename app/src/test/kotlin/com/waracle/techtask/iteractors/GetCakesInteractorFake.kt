package com.waracle.techtask.iteractors

class GetCakesInteractorFake(
    private val isSuccessful: Boolean = true
) : com.waracle.techtask.interactors.GetCakesInteractor {

    var cakes: List<com.waracle.techtask.model.CakeItemDomain>? = null

    override suspend fun invoke(): com.waracle.techtask.model.Result<List<com.waracle.techtask.model.CakeItemDomain>> {
        return if (isSuccessful) com.waracle.techtask.model.Result.Success(
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
        else com.waracle.techtask.model.Result.Error(RuntimeException("merde"))
    }
}
