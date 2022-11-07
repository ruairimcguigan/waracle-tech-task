package com.waracle.techtask.repository

import com.waracle.techtask.datasource.CakesRemoteDataSourceFake
import com.waracle.techtask.datasource.firstCake
import com.waracle.techtask.datasource.secondCake
import com.waracle.techtask.models.Result.*
import com.waracle.techtask.repo.RepositoryImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class RepositoryTest {

    private lateinit var cakesRemoteDataSourceFake: CakesRemoteDataSourceFake

    @Before
    fun setup() {
        cakesRemoteDataSourceFake = CakesRemoteDataSourceFake()
    }

    @Test
    fun `fetchCakes() returns a successful result`() = runTest {
        // given
        val repo = RepositoryImpl(
            appScope = this,
            ioDispatcher = StandardTestDispatcher(testScheduler),
            remoteDataSource = cakesRemoteDataSourceFake,
        )

        val expected = listOf(firstCake, secondCake)

        // when
        val result = repo.fetchCakes()

        // then
        assert(result is Success)
        assertEquals((result as Success).data, expected)
    }
}
