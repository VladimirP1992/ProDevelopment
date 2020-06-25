package ru.geekbrains.historyscreen

import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import ru.geekbrains.historyscreen.view.history.HistoryInteractor
import ru.geekbrains.historyscreen.view.history.HistoryViewModel

fun injectDependencies() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(listOf(historyScreen))
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}
