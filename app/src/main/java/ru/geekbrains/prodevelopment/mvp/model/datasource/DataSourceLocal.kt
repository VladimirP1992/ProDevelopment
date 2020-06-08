package ru.geekbrains.prodevelopment.mvp.model.datasource


import io.reactivex.Observable
import ru.geekbrains.prodevelopment.mvp.model.data.SearchResult

class DataSourceLocal(private val remoteProvider: RoomDataBaseImplementation = RoomDataBaseImplementation()) :
    DataSource<List<SearchResult>> {

    override fun getData(word: String): Observable<List<SearchResult>> = remoteProvider.getData(word)
}
