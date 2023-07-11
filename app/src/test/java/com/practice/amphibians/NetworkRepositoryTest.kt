package com.practice.amphibians

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class NetworkRepositoryTest {

    @Test
    fun networkAmphibianRepository_getAmphibians_verifyList() = runTest {
        val repository = NetworkRepository(ApiService())
        assertEquals(DataSource.amphibians, repository.getAmphibians())
    }
}