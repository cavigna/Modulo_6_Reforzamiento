package com.example.indicesremoto.repository

import com.example.indicesremoto.model.ResIndicador
import com.example.indicesremoto.network.IndiceApi
import kotlinx.coroutines.flow.Flow


class Repository(private val api: IndiceApi) {

    suspend fun listadoUf() = api.listadoUf()

    suspend fun ufDeHoy(fecha:String) = api.ufDeHoy(fecha)
}