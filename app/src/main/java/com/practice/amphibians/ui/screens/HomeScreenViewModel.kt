package com.practice.amphibians.ui.screens

import androidx.compose.runtime.*
import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.practice.amphibians.AmphibianApplication
import com.practice.amphibians.data.AmphibianDataRepository
import com.practice.amphibians.ui.states.AmphibianUiState
import kotlinx.coroutines.launch
import java.io.IOException

class HomeScreenViewModel(private val amphibianDataRepository: AmphibianDataRepository) :
    ViewModel() {

    var amphibianUiState: AmphibianUiState by mutableStateOf(AmphibianUiState.Loading)
        private set

    init {
        getAmphibians()
    }

    fun getAmphibians() {
        viewModelScope.launch {
            amphibianUiState = try {
                AmphibianUiState.Success(amphibianDataRepository.getAmphibians())
            } catch (e: IOException) {
                AmphibianUiState.Error
            }
        }
    }

    companion object {

        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibianApplication)
                HomeScreenViewModel(amphibianDataRepository = application.container.amphibianDataRepository)
            }
        }
    }

}