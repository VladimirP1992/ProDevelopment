package ru.geekbrains.prodevelopment.mvp.model.repository

import io.reactivex.Observable

interface IRepository<T> {

    fun getData(word: String): Observable<T>
}
