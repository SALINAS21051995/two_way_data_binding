package com.example.android.two_way_data_binding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivityViewModel(val startingTotal: Int): ViewModel() {
    private var totalCount = MutableLiveData<Int>()
    val total : LiveData<Int>
    get() = totalCount
    val inputText = MutableLiveData<String>()
    init{
        totalCount.value = startingTotal
    }

    fun updateTotal(){
        val input: Int = inputText.value!!.toInt()
        totalCount.value = totalCount.value?.plus(input)
    }
}
class MainActivityViewModelFactory(private val startingTotal: Int): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainActivityViewModel(startingTotal) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")      }

}