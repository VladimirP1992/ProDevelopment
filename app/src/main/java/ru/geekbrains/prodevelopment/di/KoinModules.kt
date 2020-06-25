package ru.geekbrains.prodevelopment.di

import androidx.room.Room
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import ru.geekbrains.model.data.DataModel
import ru.geekbrains.repository.*
//import ru.geekbrains.historyscreen.view.history.HistoryViewModel
import ru.geekbrains.prodevelopment.view.main.MainViewModel
//import ru.geekbrains.historyscreen.view.history.HistoryInteractor
import ru.geekbrains.prodevelopment.view.main.MainInteractor
import ru.geekbrains.repository.room.HistoryDataBase

fun injectDependencies() = loadModules

private val loadModules by lazy {
    loadKoinModules(listOf(application, mainScreen))
}

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<IRepository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<IRepositoryLocal<List<DataModel>>> {
        RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

