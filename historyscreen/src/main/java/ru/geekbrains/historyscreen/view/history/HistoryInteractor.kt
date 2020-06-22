package ru.geekbrains.historyscreen.view.history

import ru.geekbrains.core.viewmodel.IInteractor
import ru.geekbrains.model.data.DataModel
import ru.geekbrains.model.data.SearchResult
import ru.geekbrains.repository.IRepository
import ru.geekbrains.repository.IRepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: IRepository<List<SearchResult>>,
    private val repositoryLocal: IRepositoryLocal<List<SearchResult>>
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
