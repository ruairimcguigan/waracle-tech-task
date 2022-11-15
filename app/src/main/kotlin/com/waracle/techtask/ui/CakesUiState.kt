package com.waracle.techtask.ui

import com.waracle.techtask.model.CakeItemDomain

sealed class CakesUiState {
    data class Success(val cakes: List<CakeItemDomain>): CakesUiState()
    data class Error(val exception: Throwable): CakesUiState()
    object Loading : CakesUiState()
}
