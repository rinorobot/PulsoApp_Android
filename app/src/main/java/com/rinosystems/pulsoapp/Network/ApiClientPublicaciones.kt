package com.rinosystems.pulsoapp.Network

import com.rinosystems.pulsoapp.models.NuevoDataPublicacionesItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiClientPublicaciones {
    @GET("revistas")
    fun getPublicaciones(): Call<NuevoDataPublicacionesItem>
}