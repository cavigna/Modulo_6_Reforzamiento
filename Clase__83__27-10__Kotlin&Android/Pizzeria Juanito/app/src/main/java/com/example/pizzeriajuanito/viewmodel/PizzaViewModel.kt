package com.example.pizzeriajuanito.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pizzeriajuanito.model.Pizza

class PizzaViewModel: ViewModel() {

    var pizza :Pizza = Pizza("Juanito")
}