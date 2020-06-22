package ru.geekbrains.prodevelopment.di

import androidx.room.Room
import org.koin.dsl.module
import ru.geekbrains.model.data.SearchResult
import ru.geekbrains.repository.RetrofitImplementation
import ru.geekbrains.repository.RoomDataBaseImplementation
import ru.geekbrains.repository.IRepository
import ru.geekbrains.repository.IRepositoryLocal
import ru.geekbrains.repository.RepositoryImplementation
import ru.geekbrains.repository.RepositoryImplementationLocal
import ru.geekbrains.repository.room.HistoryDataBase
import ru.geekbrains.historyscreen.view.history.HistoryViewModel
import ru.geekbrains.prodevelopment.view.main.MainViewModel
import ru.geekbrains.historyscreen.view.history.HistoryInteractor
import ru.geekbrains.prodevelopment.view.main.MainInteractor

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<IRepository<List<SearchResult>>> {
        RepositoryImplementation(
            RetrofitImplementation()
        )
    }
    single<IRepositoryLocal<List<SearchResult>>> {
        RepositoryImplementationLocal(
            RoomDataBaseImplementation(
                get()
            )
        )
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory {
        MainInteractor(
            get(),
            get()
        )
    }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory {
        HistoryInteractor(
            get(),
            get()
        )
    }
}

