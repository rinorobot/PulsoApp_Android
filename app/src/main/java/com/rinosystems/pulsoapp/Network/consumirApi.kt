package com.rinosystems.pulsoapp.Network

import com.rinosystems.pulsoapp.models.NewsData
import com.rinosystems.pulsoapp.models.NewsDataItem
import com.rinosystems.pulsoapp.models.NoticiasData
import retrofit2.Call
import retrofit2.http.GET

interface consumirApi {

    @GET("slideshow?user_api=APPCCHN&pass_api=85c03c65ef3e2f592038057882b682127478bb38822803cd88eae903e8523ff5")
    fun getTraer(): Call<NewsData>
}