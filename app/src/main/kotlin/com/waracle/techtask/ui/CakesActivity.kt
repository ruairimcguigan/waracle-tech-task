package com.waracle.techtask.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.waracle.techtask.R
import com.waracle.techtask.ui.CakesUiState.Loading
import com.waracle.techtask.ui.theme.CakesList
import com.waracle.techtask.ui.theme.ErrorView
import com.waracle.techtask.ui.theme.LoadingProgressView
import com.waracle.techtask.ui.theme.ToolbarWithRefreshAction
import com.waracle.techtask.ui.theme.WaracleTechTaskTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CakesActivity : ComponentActivity() {

    private val viewModel by viewModels<CakesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fetchCakes()
    }

    private fun fetchCakes() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState ->
                    setContent {
                        WaracleTechTaskTheme {
                            Surface(
                                modifier = Modifier.fillMaxSize(),
                                color = MaterialTheme.colors.background
                            ) {
                                Scaffold(
                                    content = {
                                        Column {
                                            ToolbarWithRefreshAction(
                                                retryFetchCakes = { fetchCakes() },
                                                refreshIcon = R.drawable.ic_refresh
                                            )
                                            when (uiState) {
                                                Loading -> LoadingProgressView()
                                                is CakesUiState.Success -> CakesList(uiState.cakes)
                                                is CakesUiState.Error -> ErrorView(
                                                    title = R.string.cake_fetch_error_title,
                                                    retryButtonText = R.string.cake_error_dialog_retry,
                                                    errorMessage = uiState.exception.message.toString(),
                                                    retryOnError = { fetchCakes() }
                                                )
                                            }
                                        }
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
