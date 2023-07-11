package com.practice.amphibians.ui.screens

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.amphibians.network.retrofitService
import com.practice.amphibians.ui.states.AmphibianUiState
import kotlinx.coroutines.launch
import java.io.IOException

class HomeScreenViewModel : ViewModel() {

    var amphibianUiState: AmphibianUiState by mutableStateOf(AmphibianUiState.Loading)
        private set

    init {
        getAmphibians()
    }

    fun getAmphibians() {
        viewModelScope.launch {
            amphibianUiState = try {
                val result = retrofitService.getAmphibians()
                AmphibianUiState.Success(result)
            } catch (e: IOException) {
                AmphibianUiState.Error
            }
        }
    }
}