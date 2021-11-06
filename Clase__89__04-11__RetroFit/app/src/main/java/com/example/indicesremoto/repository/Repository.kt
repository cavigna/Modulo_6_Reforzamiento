package com.example.indicesremoto.repository

import com.example.indicesremoto.network.IndiceApi
import com.example.indicesremoto.utils.Utilidades.Companion.HOY


class Repository(private val api: IndiceApi) {



    suspend fun ufDeHoy(fecha:String) = api.ufDeHoy(fecha)

    suspend fun indiceDeHoy(indice:String) = api.indiceDeHoy(indice, HOY)

    suspend fun listadoIndicador(indicador: String) = api.listadoIndicador(indicador)
}

/*
    suspend fun listadoUf() = api.listadoUf()
 */