package com.practice.amphibians

import com.practice.amphibians.data.AmphibianDataRepository
import com.practice.amphibians.models.Amphibian

class NetworkRepository(private val apiService: ApiService): AmphibianDataRepository {

    override suspend fun getAmphibians(): List<Amphibian> {
        return apiService.getAmphibians()
    }
}