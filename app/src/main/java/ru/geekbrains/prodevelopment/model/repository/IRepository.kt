package ru.geekbrains.prodevelopment.model.repository

interface IRepository<T> {

    suspend fun getData(word: String): T
}
