package ru.geekbrains.prodevelopment.viewmodel.interactor

import io.reactivex.Observable
import ru.geekbrains.prodevelopment.di.NAME_LOCAL
import ru.geekbrains.prodevelopment.di.NAME_REMOTE
import ru.geekbrains.prodevelopment.model.data.AppState
import ru.geekbrains.prodevelopment.model.data.DataModel
import ru.geekbrains.prodevelopment.model.repository.IRepository
import javax.inject.Inject
import javax.inject.Named


class MainInteractor @Inject constructor(
    @Named(NAME_REMOTE) val repositoryRemote: IRepository<List<DataModel>>,
    @Named(NAME_LOCAL) val repositoryLocal: IRepository<List<DataModel>>
) : IInteractor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            repositoryRemote
        } else {
            repositoryLocal
        }.getData(word).map { AppState.Success(it) }
    }
}