package com.waracle.techtask.ui

import com.waracle.techtask.models.CakesItem

sealed class CakesUiState {
    data class Success(val cakes: List<CakesItem>): CakesUiState()
    data class Error(val exception: Throwable): CakesUiState()
    object Loading : CakesUiState()
}
