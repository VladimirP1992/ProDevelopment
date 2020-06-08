package ru.geekbrains.prodevelopment.mvp.model.repository

import io.reactivex.Observable
import ru.geekbrains.prodevelopment.mvp.model.data.SearchResult
import ru.geekbrains.prodevelopment.mvp.model.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<SearchResult>>) :
    IRepository<List<SearchResult>> {

    override fun getData(word: String): Observable<List<SearchResult>> {
        return dataSource.getData(word)
    }
}
