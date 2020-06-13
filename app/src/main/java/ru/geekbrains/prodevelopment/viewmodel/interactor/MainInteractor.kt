package ru.geekbrains.prodevelopment.viewmodel.interactor

import ru.geekbrains.prodevelopment.model.data.DataModel
import ru.geekbrains.prodevelopment.model.data.SearchResult
import ru.geekbrains.prodevelopment.model.repository.IRepository


class MainInteractor(
    private val repositoryRemote: IRepository<List<SearchResult>>,
    private val repositoryLocal: IRepository<List<SearchResult>>
) : IInteractor<DataModel> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): DataModel {
        return DataModel.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}