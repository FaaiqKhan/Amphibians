package com.practice.amphibians

import com.practice.amphibians.models.Amphibian
import com.practice.amphibians.network.AmphibianApiService

class ApiService: AmphibianApiService {

    override suspend fun getAmphibians(): List<Amphibian> {
        return DataSource.amphibians
    }
}