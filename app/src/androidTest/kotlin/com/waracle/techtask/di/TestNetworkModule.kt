package com.waracle.techtask.di

import com.squareup.moshi.Moshi
import com.waracle.techtask.annotation.BaseUrl
import com.waracle.techtask.api.CakesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [ApiModule::class]
)
object TestNetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshi: Moshi,
        @BaseUrl baseUrl: String
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
        .build()

    @Provides
    @Singleton
    fun provideApiClient(retrofit: Retrofit): CakesApi =
        retrofit.create(CakesApi::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideMockServer(): MockWebServer = MockWebServer()


    @Provides
    @Singleton
    @BaseUrl
    fun provideBaseUrl(mockWebServer: MockWebServer): String {
        var url = ""
        val thread = Thread {
            url = mockWebServer.url("/").toString()
        }
        thread.start()
        thread.join()
        return url
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().build()
}
