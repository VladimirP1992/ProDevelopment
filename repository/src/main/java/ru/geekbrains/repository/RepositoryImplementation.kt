package ru.geekbrains.repository

import ru.geekbrains.model.data.SearchResult
import ru.geekbrains.repository.DataSource
import ru.geekbrains.repository.IRepository

class RepositoryImplementation(private val dataSource: DataSource<List<SearchResult>>) :
    IRepository<List<SearchResult>> {

    override suspend fun getData(word: String): List<SearchResult> {
        return dataSource.getData(word)
    }
}
