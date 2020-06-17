package ru.geekbrains.prodevelopment.model.repository

import ru.geekbrains.prodevelopment.model.data.DataModel
import ru.geekbrains.prodevelopment.model.data.SearchResult
import ru.geekbrains.prodevelopment.model.datasource.DataSourceLocal

class RepositoryImplementationLocal(private val dataSource: DataSourceLocal<List<SearchResult>>) :
    IRepositoryLocal<List<SearchResult>> {

    override suspend fun getData(word: String): List<SearchResult> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDB(dataModel: DataModel) {
        dataSource.saveToDB(dataModel)
    }
}