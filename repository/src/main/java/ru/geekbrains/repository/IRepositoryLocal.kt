package ru.geekbrains.repository

import ru.geekbrains.model.data.DataModel

interface IRepositoryLocal<T> : IRepository<T> {

    suspend fun saveToDB(dataModel: DataModel)
}