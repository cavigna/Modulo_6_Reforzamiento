package com.example.indicesremoto.repository

import com.example.indicesremoto.model.ResIndicador
import com.example.indicesremoto.network.IndiceApi
import kotlinx.coroutines.flow.Flow


class Repository(private val api: IndiceApi) {

    fun listadoUf() = api.listadoUf()
}