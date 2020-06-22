package ru.geekbrains.prodevelopment.view.main

import ru.geekbrains.core.viewmodel.IInteractor
import ru.geekbrains.model.data.DataModel
import ru.geekbrains.model.data.SearchResult
import ru.geekbrains.repository.IRepository
import ru.geekbrains.repository.IRepositoryLocal


class MainInteractor(
    private val repositoryRemote: IRepository<List<SearchResult>>,
    private val repositoryLocal: IRepositoryLocal<List<SearchResult>>
) : IInteractor<DataModel> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): DataModel {
        val dataModel: DataModel
        if (fromRemoteSource) {
            dataModel = DataModel.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(dataModel)
        } else {
            dataModel = DataModel.Success(repositoryLocal.getData(word))
        }
        return dataModel
    }
}