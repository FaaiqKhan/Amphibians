package com.practice.amphibians.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.practice.amphibians.R
import com.practice.amphibians.ui.screens.HomeScreen
import com.practice.amphibians.ui.screens.HomeScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibiansApp() {
    Scaffold(
        topBar = { AmphibianTopAppBar() }
    ) {
        val homeScreenViewModel: HomeScreenViewModel = viewModel()
        HomeScreen(
            uiState = homeScreenViewModel.amphibianUiState,
            retryAction = homeScreenViewModel::getAmphibians,
            modifier = Modifier.padding(it)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibianTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
            )
        },
        modifier = modifier
    )
}