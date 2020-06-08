package ru.geekbrains.prodevelopment.mvp.view

import ru.geekbrains.prodevelopment.mvp.model.data.DataModel

interface View {
    fun renderData(dataModel: DataModel)
}