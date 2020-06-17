package ru.geekbrains.prodevelopment.model.datasource

interface DataSource<T> {

    suspend fun getData(word: String): T
}
