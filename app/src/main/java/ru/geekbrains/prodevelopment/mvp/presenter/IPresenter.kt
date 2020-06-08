package ru.geekbrains.prodevelopment.mvp.presenter

import ru.geekbrains.prodevelopment.mvp.model.data.DataModel
import ru.geekbrains.prodevelopment.mvp.view.View

interface IPresenter<T : DataModel, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}
