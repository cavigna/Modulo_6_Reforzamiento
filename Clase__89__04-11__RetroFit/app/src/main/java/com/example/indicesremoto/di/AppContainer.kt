package com.example.indicesremoto.di

import com.example.indicesremoto.network.IndiceApi
import com.example.indicesremoto.repository.Repository
import com.example.indicesremoto.viewmodel.IndiceFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class AppContainer {

    private val retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://mindicador.cl/api/")
            .build()
            .create(IndiceApi::class.java)

    val repository = Repository(retrofit)

    val factory = IndiceFactory(repository)




}