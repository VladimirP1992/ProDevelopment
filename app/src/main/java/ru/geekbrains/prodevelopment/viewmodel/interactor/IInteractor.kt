package ru.geekbrains.prodevelopment.viewmodel.interactor


interface IInteractor<T> {

    suspend fun getData(word: String, fromRemoteSource: Boolean): T
}