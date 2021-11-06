package com.example.indicesremoto.viewmodel

import android.annotation.SuppressLint
import android.icu.util.Calendar
import androidx.lifecycle.*
import com.example.indicesremoto.model.ResIndicador
import com.example.indicesremoto.repository.Repository
import com.example.indicesremoto.utils.Utilidades.Companion.HOY
import com.example.indicesremoto.utils.dameLaFecha
import com.example.indicesremoto.utils.fromTimestamp
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("NewApi")
class IndiceViewModel(private val repository: Repository): ViewModel() {

    var data  = MutableLiveData<ResIndicador>()

    private val _ufHoy: MutableLiveData<ResIndicador> = MutableLiveData()
    val ufHoy : LiveData<ResIndicador> = _ufHoy



    init{
        listadoUf()

        ufDeHoy()
    }

    fun listadoUf(){
        viewModelScope.launch {
            data.postValue(repository.listadoUf())
        }
    }

    fun ufDeHoy(){
        viewModelScope.launch {
            _ufHoy.postValue(repository.ufDeHoy(HOY))
        }
    }
//
//     fun uf2(): LiveData<ResIndicador> {
//        return repository.ufDeHoy(hoy).body()?.asLiveData()!!
//    }
}






