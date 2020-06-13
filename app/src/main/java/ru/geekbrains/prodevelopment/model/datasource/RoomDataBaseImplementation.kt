package ru.geekbrains.prodevelopment.model.datasource

import ru.geekbrains.prodevelopment.model.data.SearchResult

class RoomDataBaseImplementation : DataSource<List<SearchResult>> {

    override suspend fun getData(word: String): List<SearchResult> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
