package com.svape.testretrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ServiceInterface {

    @Headers("Content-Type:application/json")
    @GET("/naturalearth-3.3.0/ne_50m_populated_places_simple.geojson")
    fun getGeoJson(): Call<ApiResponse>
}