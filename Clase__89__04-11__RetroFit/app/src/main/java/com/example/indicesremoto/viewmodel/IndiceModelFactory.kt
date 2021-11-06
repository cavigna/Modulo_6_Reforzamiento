package com.example.indicesremoto.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.indicesremoto.repository.Repository

class IndiceModelFactory (private val repository: Repository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return IndiceViewModel(repository) as T
    }
}



/*
//class IndiceFactory(private val repository: Repository) : ViewModelProvider.Factory{
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return IndiceViewModel(repository) as T
//    }
//
//}
 */
/*
    interface Factory {
        fun create(): T

    }

    class IndiceFactory(private val repository: Repository) : Factory{
        override fun create(): Factory.T {
            return IndiceViewModel(repository)
        }
    }
 */