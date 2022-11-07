package com.waracle.techtask.ui

sealed class CakesUiState {
    data class Success(val cakes: List<CakeUi>): CakesUiState()
    data class Error(val exception: Throwable): CakesUiState()
    object Loading : CakesUiState()
}
