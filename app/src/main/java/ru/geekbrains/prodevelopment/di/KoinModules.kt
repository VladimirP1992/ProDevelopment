package ru.geekbrains.prodevelopment.di

import androidx.room.Room
import org.koin.dsl.module
import ru.geekbrains.prodevelopment.model.data.SearchResult
import ru.geekbrains.prodevelopment.model.datasource.RetrofitImplementation
import ru.geekbrains.prodevelopment.model.datasource.RoomDataBaseImplementation
import ru.geekbrains.prodevelopment.model.repository.IRepository
import ru.geekbrains.prodevelopment.model.repository.IRepositoryLocal
import ru.geekbrains.prodevelopment.model.repository.RepositoryImplementation
import ru.geekbrains.prodevelopment.model.repository.RepositoryImplementationLocal
import ru.geekbrains.prodevelopment.room.HistoryDataBase
import ru.geekbrains.prodevelopment.viewmodel.HistoryViewModel
import ru.geekbrains.prodevelopment.viewmodel.MainViewModel
import ru.geekbrains.prodevelopment.viewmodel.interactor.HistoryInteractor
import ru.geekbrains.prodevelopment.viewmodel.interactor.MainInteractor

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<IRepository<List<SearchResult>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<IRepositoryLocal<List<SearchResult>>> { RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}

