package com.waracle.techtask.cakes

import com.waracle.techtask.datasource.*
import com.waracle.techtask.iteractors.GetCakesInteractorFake
import com.waracle.techtask.iteractors.filteredCakeResponse
import com.waracle.techtask.iteractors.sortedCakeResponse
import com.waracle.techtask.ui.CakesUiState
import com.waracle.techtask.ui.CakesViewModel
import com.waracle.techtask.util.CoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class CakesViewModelTest {

    @get:Rule
    val coroutineRule = CoroutineRule()

    @Test
    fun `creating a viewmodel exposes loading ui state`() {
        // given
        val viewModel = CakesViewModel(GetCakesInteractorFake())

        // then
        assert(viewModel.uiState.value is CakesUiState.Loading)
    }

    @Test
    fun `creating a viewmodel updates ui state to success after loading`() {
        // given
        val viewModel = CakesViewModel(GetCakesInteractorFake())

        val expectedUiState = CakesUiState.Success(sortedCakeResponse)

        // when
        coroutineRule.testDispatcher.scheduler.runCurrent()

        // then
        val actualState = viewModel.uiState.value
        assertEquals(expectedUiState, actualState)
    }

    @Test
    fun `creating a viewmodel updates ui state to error in case of failure`() {
        // given
        val viewModel = CakesViewModel(GetCakesInteractorFake(isSuccessful = false))

        // when
        coroutineRule.testDispatcher.scheduler.runCurrent()

        // then
        val currentState = viewModel.uiState.value
        assert(currentState is CakesUiState.Error)
    }

    @Test
    fun `response should be sorted by name and emitted to view`() {

        // given
        val viewModel = CakesViewModel(GetCakesInteractorFake())
        val expectedUiState = CakesUiState.Success(sortedCakeResponse)

        // when
        coroutineRule.testDispatcher.scheduler.runCurrent()

        // then
        val actualState = viewModel.uiState.value
        assertEquals(expectedUiState, actualState)

    }

    @Test
    fun `response should be filtered to remove duplicates and emitted to view`() {

        // given
        val viewModel = CakesViewModel(GetCakesInteractorFake())
        val expectedUiState = CakesUiState.Success(filteredCakeResponse)

        // when
        coroutineRule.testDispatcher.scheduler.runCurrent()

        // then
        val actualState = viewModel.uiState.value
        assertEquals(expectedUiState, actualState)

    }
}
