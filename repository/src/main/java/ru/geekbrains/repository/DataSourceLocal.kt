package ru.geekbrains.repository

import ru.geekbrains.model.data.DataModel

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(dataModel: DataModel)
}