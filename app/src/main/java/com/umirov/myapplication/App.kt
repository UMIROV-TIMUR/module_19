package com.umirov.myapplication

import android.app.Application
import com.umirov.myapplication.data.MainRepository
import com.umirov.myapplication.domain.Interactor

class App : Application() {
    lateinit var repo: MainRepository
    lateinit var interactor: Interactor

    override fun onCreate() {
        super.onCreate()
        instance = this
        repo = MainRepository()
        interactor = Interactor(repo)
    }

    companion object {
        lateinit var instance: App

            private set
    }

}