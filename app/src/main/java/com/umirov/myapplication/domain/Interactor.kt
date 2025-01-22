package com.umirov.myapplication.domain

import com.umirov.myapplication.data.MainRepository

class Interactor(val repo: MainRepository) {
    fun getFilmsDB() : List<Film> = repo.filmsDataBase
}