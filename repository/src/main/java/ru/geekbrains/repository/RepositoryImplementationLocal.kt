package ru.geekbrains.repository

import ru.geekbrains.model.data.DataModel
import ru.geekbrains.model.data.SearchResult
import ru.geekbrains.repository.DataSourceLocal
import ru.geekbrains.repository.IRepositoryLocal

class RepositoryImplementationLocal(private val dataSource: DataSourceLocal<List<SearchResult>>) :
    IRepositoryLocal<List<SearchResult>> {

    override suspend fun getData(word: String): List<SearchResult> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDB(dataModel: DataModel) {
        dataSource.saveToDB(dataModel)
    }
}