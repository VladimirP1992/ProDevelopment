package ru.geekbrains.repository

import ru.geekbrains.model.data.AppState

interface IRepositoryLocal<T> : IRepository<T> {

    suspend fun saveToDB(appState: AppState)
}