package com.example.indicesremoto.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.indicesremoto.repository.Repository

class IndiceViewModel(repository: Repository): ViewModel() {
    val listadoUf = repository.listadoUf().asLiveData()
}



class IndiceFactory(private val repository: Repository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return IndiceViewModel(repository) as T
    }

}

/*
class ConsumoViewModelFactory(private val repository: RepositoryConsumo) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((ConsumoViewModel::class.java))) {
            return ConsumoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}
 */