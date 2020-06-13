package ru.geekbrains.prodevelopment.model.repository

import io.reactivex.Observable

interface IRepository<T> {

    suspend fun getData(word: String): T
}
