package ru.geekbrains.prodevelopment.ui.Base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.geekbrains.prodevelopment.mvp.model.data.DataModel
import ru.geekbrains.prodevelopment.mvp.presenter.IPresenter
import ru.geekbrains.prodevelopment.mvp.view.View

abstract class BaseActivity<T : DataModel> : AppCompatActivity(), View {

    protected lateinit var presenter: IPresenter<T, View>

    protected abstract fun createPresenter(): IPresenter<T, View>

    abstract override fun renderData(dataModel: DataModel)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView(this)
    }
}