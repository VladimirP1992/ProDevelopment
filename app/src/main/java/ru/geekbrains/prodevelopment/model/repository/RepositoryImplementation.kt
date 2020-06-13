package ru.geekbrains.prodevelopment.model.repository

import io.reactivex.Observable
import ru.geekbrains.prodevelopment.model.data.SearchResult
import ru.geekbrains.prodevelopment.model.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<SearchResult>>) :
    IRepository<List<SearchResult>> {

    override suspend fun getData(word: String): List<SearchResult> {
        return dataSource.getData(word)
    }
}
