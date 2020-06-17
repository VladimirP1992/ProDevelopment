package ru.geekbrains.prodevelopment.model.datasource

import ru.geekbrains.prodevelopment.model.data.DataModel
import ru.geekbrains.prodevelopment.model.data.SearchResult
import ru.geekbrains.prodevelopment.room.HistoryDao
import ru.geekbrains.prodevelopment.utils.convertDataModelSuccessToEntity
import ru.geekbrains.prodevelopment.utils.mapHistoryEntityToSearchResult

class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<SearchResult>> {

    override suspend fun getData(word: String): List<SearchResult> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(dataModel: DataModel) {
        convertDataModelSuccessToEntity(dataModel)?.let {
            historyDao.insert(it)
        }
    }
}