package com.practice.amphibians.ui.states

import com.practice.amphibians.models.Amphibian

sealed interface AmphibianUiState {
    data class Success(val amphibians: List<Amphibian>) : AmphibianUiState
    object Error : AmphibianUiState
    object Loading : AmphibianUiState
}
