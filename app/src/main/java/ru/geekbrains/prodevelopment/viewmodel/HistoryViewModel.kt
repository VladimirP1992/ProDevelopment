package ru.geekbrains.prodevelopment.viewmodel

import androidx.lifecycle.LiveData
import kotlinx.coroutines.launch
import ru.geekbrains.prodevelopment.model.data.DataModel
import ru.geekbrains.prodevelopment.utils.parseLocalSearchResults
import ru.geekbrains.prodevelopment.viewmodel.interactor.HistoryInteractor

class HistoryViewModel(private val interactor: HistoryInteractor) :
    BaseViewModel<DataModel>() {

    private val liveDataForViewToObserve: LiveData<DataModel> = _mutableLiveData

    fun subscribe(): LiveData<DataModel> {
        return liveDataForViewToObserve
    }

    override fun getData(word: String, isOnline: Boolean) {
        _mutableLiveData.value = DataModel.Loading(null)
        cancelJob()
        viewModelCoroutineScope.launch { startInteractor(word, isOnline) }
    }

    private suspend fun startInteractor(word: String, isOnline: Boolean) {
        _mutableLiveData.postValue(parseLocalSearchResults(interactor.getData(word, isOnline)))
    }

    override fun handleError(error: Throwable) {
        _mutableLiveData.postValue(DataModel.Error(error))
    }

    override fun onCleared() {
        _mutableLiveData.value = DataModel.Success(null)//Set View to original state in onStop
        super.onCleared()
    }
}