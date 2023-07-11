package com.practice.amphibians.data

import com.practice.amphibians.models.Amphibian
import com.practice.amphibians.network.AmphibianApiService

fun interface AmphibianDataRepository {

    suspend fun getAmphibians(): List<Amphibian>
}

class NetworkAmphibianDataRepository(private val amphibianApiService: AmphibianApiService) :
    AmphibianDataRepository {

    override suspend fun getAmphibians(): List<Amphibian> {
        return amphibianApiService.getAmphibians()
    }

}