package ru.geekbrains.prodevelopment.model.repository

import ru.geekbrains.prodevelopment.model.data.DataModel

interface IRepositoryLocal<T> : IRepository<T> {

    suspend fun saveToDB(dataModel: DataModel)
}