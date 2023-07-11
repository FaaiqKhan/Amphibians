package com.practice.amphibians.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.practice.amphibians.data.*
import com.practice.amphibians.models.Amphibian
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

fun interface AmphibianApiService {

    @GET("amphibians")
    suspend fun getAmphibians(): List<Amphibian>
}

class AmphibianServiceContainer : AppContainer {

    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: AmphibianApiService by lazy {
        retrofit.create(AmphibianApiService::class.java)
    }

    override val amphibianDataRepository: AmphibianDataRepository by lazy {
        NetworkAmphibianDataRepository(retrofitService)
    }

}