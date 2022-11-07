package com.waracle.techtask.ui.cakes

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils.loadAnimation
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.waracle.techtask.R
import com.waracle.techtask.databinding.CakesActivityBinding
import com.waracle.techtask.ext.gone
import com.waracle.techtask.ext.visible
import com.waracle.techtask.models.CakesItem
import com.waracle.techtask.ui.CakesUiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CakesActivity : AppCompatActivity() {

    private val viewModel by viewModels<CakesViewModel>()

    private lateinit var viewBinding: CakesActivityBinding
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: CakesAdapter
    private lateinit var errorDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = CakesActivityBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setSupportActionBar(viewBinding.toolbar)
        fetchCakes()
        observeCakes()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_cakes, menu)
        return true
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {R.id.refreshOnError -> fetchCakes() }
        return super.onOptionsItemSelected(menuItem)
    }

    private fun fetchCakes() {
        viewBinding.progressBar.visible()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState ->
                    when (uiState) {
                        CakesUiState.Loading -> viewBinding.progressBar.visible()
                        is CakesUiState.Success -> showCakes(uiState.cakes)
                        is CakesUiState.Error -> {
                            displayError(uiState.exception.message.toString())
                        }
                    }
                }
            }
        }
    }

    private fun observeCakes() {
        layoutManager = LinearLayoutManager(this)
        adapter = CakesAdapter { cake: CakesItem -> launchCakeDescDialog(cake.desc) }
        viewBinding.cakesList.animation = loadAnimation(this, R.anim.rotate)
        viewBinding.cakesList.adapter = adapter
        viewBinding.cakesList.layoutManager = layoutManager
        viewBinding.cakesList.addItemDecoration(
            DividerItemDecoration(
                baseContext,
                layoutManager.orientation
            )
        )
    }

    private fun showCakes(cakes: List<CakesItem>) {
        viewBinding.progressBar.gone()
        viewBinding.cakesList.visible()
        adapter.populate(cakes)
    }

    private fun displayError(message: String) {
        viewBinding.progressBar.gone()
        viewBinding.cakesList.gone()
        allowRetryOnError(message)
    }

    private fun launchCakeDescDialog(cakeDesc: String) {
        AlertDialog.Builder(this)
            .setTitle(R.string.cake_desc_title)
            .setMessage(cakeDesc)
            .setPositiveButton(getString(R.string.cake_desc_acknowledge))
            { dialog, _ -> dialog.cancel() }
            .show()
    }

    private fun allowRetryOnError(errorMessage: String) {
        AlertDialog.Builder(this)
            .setTitle(R.string.cake_fetch_error_title)
            .setMessage(errorMessage)
            .setNegativeButton(getString(R.string.cake_error_dialog_dismiss))
            { _, _ -> finish() }
            .setPositiveButton(getString(R.string.cake_error_dialog_retry))
            { _, _ ->
                run {
                    errorDialog.dismiss()
                    errorDialog.cancel()
                    fetchCakes()
                }
            }
            .show()
    }
}
