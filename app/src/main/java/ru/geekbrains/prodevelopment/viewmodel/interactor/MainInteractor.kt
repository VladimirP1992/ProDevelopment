package ru.geekbrains.prodevelopment.viewmodel.interactor

import ru.geekbrains.prodevelopment.model.data.DataModel
import ru.geekbrains.prodevelopment.model.data.SearchResult
import ru.geekbrains.prodevelopment.model.repository.IRepository
import ru.geekbrains.prodevelopment.model.repository.IRepositoryLocal


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