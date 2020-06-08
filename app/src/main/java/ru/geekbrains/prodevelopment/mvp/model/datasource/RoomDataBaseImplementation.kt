package ru.geekbrains.prodevelopment.mvp.model.datasource

import io.reactivex.Observable
import ru.geekbrains.prodevelopment.mvp.model.data.SearchResult

class RoomDataBaseImplementation : DataSource<List<SearchResult>> {

    override fun getData(word: String): Observable<List<SearchResult>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
