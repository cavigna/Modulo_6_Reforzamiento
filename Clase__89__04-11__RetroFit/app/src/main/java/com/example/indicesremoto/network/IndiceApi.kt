package com.example.indicesremoto.network

import com.example.indicesremoto.model.ResIndicador
import com.example.indicesremoto.utils.Utilidades.Companion.HOY
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface IndiceApi {




    @GET("uf/{fecha}")
    suspend fun ufDeHoy(@Path("fecha") fecha: String): ResIndicador

    @GET("{indicador}/{fecha}")
    suspend fun indiceDeHoy(
        @Path("indicador") indicador: String,
        @Path("fecha") fecha: String,

        ): ResIndicador

    @GET("{indicador}")
    suspend fun listadoIndicador(@Path("indicador") indicador: String): ResIndicador
}

/*
    @GET("uf")
    suspend fun listadoUf(): ResIndicador
 */