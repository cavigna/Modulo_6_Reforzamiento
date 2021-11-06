package com.example.indicesremoto.repository

import com.example.indicesremoto.network.IndiceApi


class Repository(private val api: IndiceApi) {

    suspend fun listadoUf() = api.listadoUf()

    suspend fun ufDeHoy(fecha:String) = api.ufDeHoy(fecha)
}