package com.example.indicesremoto.viewmodel

import android.annotation.SuppressLint
import android.icu.util.Calendar
import androidx.lifecycle.*
import com.example.indicesremoto.model.ResIndicador
import com.example.indicesremoto.repository.Repository
import com.example.indicesremoto.utils.dameLaFecha
import com.example.indicesremoto.utils.fromTimestamp
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("NewApi")
class IndiceViewModel(private val repository: Repository): ViewModel() {

    var data  = MutableLiveData<ResIndicador>()

    var ufHoyMutable = MutableLiveData<ResIndicador>()

    var hoy = ""

    init{
        listadoUf()
        hoy = dameLaFecha()
        ufDeHoy()
    }

    fun listadoUf(){
        viewModelScope.launch {
            data.postValue(repository.listadoUf())
        }
    }

    fun ufDeHoy(){
        viewModelScope.launch {
            ufHoyMutable.postValue( repository.ufDeHoy(hoy))
        }
    }

    suspend fun uf2(): ResIndicador {
        return repository.ufDeHoy(hoy)
    }
}






