package com.practice.amphibians.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.dp
import com.practice.amphibians.R
import com.practice.amphibians.models.Amphibian
import com.practice.amphibians.ui.common.AmphibianCard
import com.practice.amphibians.ui.states.AmphibianUiState

@Composable
fun HomeScreen(uiState: AmphibianUiState, retryAction: () -> Unit, modifier: Modifier = Modifier) {
    when (uiState) {
        is AmphibianUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxWidth())
        is AmphibianUiState.Success -> SuccessScreen(
            amphibians = uiState.amphibians,
            modifier = modifier
        )

        is AmphibianUiState.Error -> ErrorScreen(
            retryAction = retryAction,
            modifier = modifier.fillMaxWidth()
        )
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(id = R.drawable.loading_img),
        contentDescription = stringResource(id = R.string.loading)
    )
}

@Composable
fun SuccessScreen(amphibians: List<Amphibian>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.padding(horizontal = dimensionResource(id = R.dimen.list_padding)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.list_spacing))
    ) {
        items(items = amphibians) {
            AmphibianCard(amphibian = it)
        }
    }
}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error),
            contentDescription = stringResource(id = R.string.connection_error)
        )
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
        Button(onClick = retryAction) {
            Text(text = stringResource(id = R.string.retry))
        }
    }
}