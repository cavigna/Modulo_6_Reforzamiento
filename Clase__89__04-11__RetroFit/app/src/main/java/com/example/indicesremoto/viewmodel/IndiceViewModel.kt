package com.example.indicesremoto.viewmodel

import android.annotation.SuppressLint
import android.icu.util.Calendar
import android.util.Log
import androidx.lifecycle.*
import com.example.indicesremoto.model.ResIndicador
import com.example.indicesremoto.repository.Repository
import com.example.indicesremoto.utils.Utilidades.Companion.HOY
import com.example.indicesremoto.utils.dameLaFecha
import com.example.indicesremoto.utils.fromTimestamp
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("NewApi")
class IndiceViewModel(private val repository: Repository): ViewModel() {

    private val _ufHoy: MutableLiveData<ResIndicador> = MutableLiveData()
    val ufHoy : LiveData<ResIndicador> = _ufHoy

    private val _utmHoy = MutableLiveData<ResIndicador>()
    val utmHoy :LiveData<ResIndicador> = _utmHoy


    private val _dolarHoy : MutableLiveData<ResIndicador> = MutableLiveData<ResIndicador>()
    val dolarHoy: LiveData<ResIndicador> = _dolarHoy

    private val _euroHoy = MutableLiveData<ResIndicador>()
    val euroHoy: LiveData<ResIndicador> = _euroHoy





    init{


        //ufDeHoy()

        listadoIndicador("dolar", _dolarHoy)
        listadoIndicador("uf", _ufHoy)
        listadoIndicador("utm", _utmHoy)
        listadoIndicador("euro", _euroHoy)
    }



    fun ufDeHoy(){
        viewModelScope.launch {
            _ufHoy.postValue(repository.ufDeHoy(HOY))
        }
    }



    fun listadoIndicador(indicador: String, mutable: MutableLiveData<ResIndicador>){
        viewModelScope.launch {
            mutable.postValue((repository.listadoIndicador(indicador)))
        }

    }

}




/*
    fun listadoUf(){
        viewModelScope.launch {
            data.postValue(repository.listadoUf())
        }
    }
 */

