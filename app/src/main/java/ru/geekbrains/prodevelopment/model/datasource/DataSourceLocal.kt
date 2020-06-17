package ru.geekbrains.prodevelopment.model.datasource

import ru.geekbrains.prodevelopment.model.data.DataModel

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(dataModel: DataModel)
}