package com.practice.amphibians

import android.app.Application
import com.practice.amphibians.data.AppContainer
import com.practice.amphibians.network.AmphibianServiceContainer

class AmphibianApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AmphibianServiceContainer()
    }
}