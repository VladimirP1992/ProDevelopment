package ru.geekbrains.historyscreen

import ru.geekbrains.model.data.DataModel
import ru.geekbrains.model.data.Meanings
import ru.geekbrains.model.data.SearchResult

fun parseLocalSearchResults(data: DataModel): DataModel {
    return DataModel.Success(mapResult(data, false))
}

private fun mapResult(
    data: DataModel,
    isOnline: Boolean
): List<SearchResult> {
    val newSearchResults = arrayListOf<SearchResult>()
    when (data) {
        is DataModel.Success -> {
            getSuccessResultData(data, isOnline, newSearchResults)
        }
    }
    return newSearchResults
}

private fun getSuccessResultData(
    data: DataModel.Success,
    isOnline: Boolean,
    newDataModels: ArrayList<SearchResult>
) {
    val dataModels: List<SearchResult> = data.data as List<SearchResult>
    if (dataModels.isNotEmpty()) {
        if (isOnline) {
            for (searchResult in dataModels) {
                parseOnlineResult(searchResult, newDataModels)
            }
        } else {
            for (searchResult in dataModels) {
                newDataModels.add(SearchResult(searchResult.text, arrayListOf()))
            }
        }
    }
}

private fun parseOnlineResult(dataModel: SearchResult, newDataModels: ArrayList<SearchResult>) {
    if (!dataModel.text.isNullOrBlank() && !dataModel.meanings.isNullOrEmpty()) {
        val newMeanings = arrayListOf<Meanings>()
        for (meaning in dataModel.meanings!!) {
            if (meaning.translation != null && !meaning.translation!!.translation.isNullOrBlank()) {
                newMeanings.add(Meanings(meaning.translation, meaning.imageUrl))
            }
        }
        if (newMeanings.isNotEmpty()) {
            newDataModels.add(SearchResult(dataModel.text, newMeanings))
        }
    }
}
