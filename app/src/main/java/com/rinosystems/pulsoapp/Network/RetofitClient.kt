package com.rinosystems.pulsoapp.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetofitClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://www.cch-naucalpan.unam.mx/Api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val consumirApi = retrofit.create(consumirApi::class.java)

    private val baseUrlPublicaciones = Retrofit.Builder()
        .baseUrl("http://demo2495997.mockable.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiPublicaciones = baseUrlPublicaciones.create(ApiClientPublicaciones::class.java)


}