package com.waracle.techtask.datasource

import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi
import com.waracle.techtask.api.CakesApi
import com.waracle.techtask.model.Result.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@ExperimentalCoroutinesApi
class CakesRemoteDataSourceImplTest {

    private lateinit var api: CakesApi
    private lateinit var mockWebServer: MockWebServer
    private lateinit var remoteSource: CakesRemoteDataSourceImpl

    private val client = OkHttpClient.Builder().build()
    private val moshi: Moshi = Moshi.Builder().build()

    @Before
    fun createServer() {
        mockWebServer = MockWebServer()

        api = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
            .build()
            .create(CakesApi::class.java)

        remoteSource = CakesRemoteDataSourceImpl(api)
    }

    @After
    fun shutdownServer() {
        mockWebServer.shutdown()
    }

    @Test
    fun `correct response is parsed into success result`() = runTest {
        // given
        val response = MockResponse().setBody(successfulResponse).setResponseCode(200)
        mockWebServer.enqueue(response)
        val expectedResponse = Success(cakesResponse)

        // when
        val result = remoteSource.fetchCakes()

        // then
        assert(result is Success)
        assertEquals(expectedResponse, Success(result).data)
    }

    @Test
    fun `bad response returns json error result`() = runTest {
        // given
        val response = MockResponse().setBody(errorResponse).setResponseCode(200)
        mockWebServer.enqueue(response)

        // when
        val result = remoteSource.fetchCakes()

        // then
        assert(result is Error)
        assert((result as Error).error is JsonDataException)
    }

    @Test
    fun `error response returns http error result`() = runTest {
        // given
        val response = MockResponse().setBody(errorResponse).setResponseCode(400)
        mockWebServer.enqueue(response)

        // when
        val result = remoteSource.fetchCakes()

        // then
        assert(result is Error)
        assert((result as Error).error is HttpException)
    }
}
