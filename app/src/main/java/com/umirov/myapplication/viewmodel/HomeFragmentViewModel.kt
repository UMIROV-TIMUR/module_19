package com.umirov.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.umirov.myapplication.App
import com.umirov.myapplication.domain.Film
import com.umirov.myapplication.domain.Interactor

class HomeFragmentViewModel : ViewModel() {
    val filmsListLiveData : MutableLiveData<List<Film>> = MutableLiveData()
    private  var interactor: Interactor = App.instance.interactor
    init {

        val films = interactor.getFilmsDB()
        filmsListLiveData.postValue(films)
    }
}