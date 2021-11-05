package com.example.indicesremoto.network

import com.example.indicesremoto.model.ResIndicador
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET


interface IndiceApi {

    @GET("uf")
    fun listadoUf(): Flow<ResIndicador>
}