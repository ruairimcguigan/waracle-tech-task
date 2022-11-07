package com.waracle.techtask.api

import com.waracle.techtask.model.CakeItemDomain
import retrofit2.http.GET

interface CakesApi {
    @GET("waracle_cake-android-client")
    suspend fun getCakes(): List<CakeItemDomain>
}
