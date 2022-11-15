package com.waracle.techtask.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waracle.techtask.interactors.GetCakesInteractor
import com.waracle.techtask.ui.CakesUiState.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CakesViewModel @Inject constructor(
    private val getCakesInteractor: GetCakesInteractor,
) : ViewModel() {

    private val _uiState = MutableStateFlow<CakesUiState>(CakesUiState.Loading)
    val uiState: StateFlow<CakesUiState> = _uiState

    private var loadingJob: Job? = null

    init {
        getCakes()
    }

    private fun getCakes() {
        _uiState.value = CakesUiState.Loading

        loadingJob?.cancel()
        loadingJob = viewModelScope.launch {
            when (val response = getCakesInteractor()) {
                is com.waracle.techtask.model.Result.Success ->
                    Success(cakes = response.data
                        .sortedBy { it.title }
                        .distinct()).also {
                        _uiState.value = it
                    }

                is com.waracle.techtask.model.Result.Error ->
                    _uiState.value = response.error
                        .takeUnless { it is CancellationException }
                        ?.let(CakesUiState::Error)
                        ?: CakesUiState.Loading
            }
        }
    }
}
