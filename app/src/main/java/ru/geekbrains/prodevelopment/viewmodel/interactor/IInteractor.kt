package ru.geekbrains.prodevelopment.viewmodel.interactor

import io.reactivex.Observable

interface IInteractor<T> {

    fun getData(word: String, fromRemoteSource: Boolean): Observable<T>
}