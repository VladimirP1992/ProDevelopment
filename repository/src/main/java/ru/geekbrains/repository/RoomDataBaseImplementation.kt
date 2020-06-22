package ru.geekbrains.repository

import ru.geekbrains.model.data.DataModel
import ru.geekbrains.model.data.SearchResult
import ru.geekbrains.repository.room.HistoryDao

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