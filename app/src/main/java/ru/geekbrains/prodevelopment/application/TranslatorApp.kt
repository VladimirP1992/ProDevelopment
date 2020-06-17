package ru.geekbrains.prodevelopment.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.geekbrains.prodevelopment.di.application
import ru.geekbrains.prodevelopment.di.historyScreen
import ru.geekbrains.prodevelopment.di.mainScreen


class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, mainScreen, historyScreen))
        }
    }
}