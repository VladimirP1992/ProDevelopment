package ru.geekbrains.prodevelopment.mvp.presenter

import io.reactivex.Observable
import ru.geekbrains.prodevelopment.mvp.model.data.DataModel
import ru.geekbrains.prodevelopment.mvp.model.data.SearchResult
import ru.geekbrains.prodevelopment.mvp.model.repository.IRepository


class MainInteractor(
    private val remoteRepository: IRepository<List<SearchResult>>,
    private val localRepository: IRepository<List<SearchResult>>
) : IInteractor<DataModel> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<DataModel> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { DataModel.Success(it) }
        } else {
            localRepository.getData(word).map { DataModel.Success(it) }
        }
    }
}
