package ru.geekbrains.prodevelopment.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.geekbrains.prodevelopment.model.data.SearchResult
import ru.geekbrains.prodevelopment.model.datasource.RetrofitImplementation
import ru.geekbrains.prodevelopment.model.datasource.RoomDataBaseImplementation
import ru.geekbrains.prodevelopment.model.repository.IRepository
import ru.geekbrains.prodevelopment.model.repository.RepositoryImplementation
import ru.geekbrains.prodevelopment.viewmodel.MainViewModel
import ru.geekbrains.prodevelopment.viewmodel.interactor.MainInteractor

val application = module {
    single<IRepository<List<SearchResult>>>(named(NAME_REMOTE)) { RepositoryImplementation(RetrofitImplementation()) }
    single<IRepository<List<SearchResult>>>(named(NAME_LOCAL)) { RepositoryImplementation(RoomDataBaseImplementation()) }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}
