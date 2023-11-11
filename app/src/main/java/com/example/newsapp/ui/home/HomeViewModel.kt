package com.example.newsapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.models.Everything
import com.example.newsapp.data.repositories.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val repository: NewsRepository?): ViewModel(){
    private val _everythingList = MutableLiveData<Everything?>()
    val everythingList: LiveData<Everything> get() = everythingList

    val errorMessage = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()

    fun getEverything() {
        viewModelScope.launch {
            val response = repository?.getEverything()
            withContext(Dispatchers.Main) {
                    _everythingList.postValue(response)
                    loading.value = false
            }
        }


//        viewModelScope.launch {
//            withContext(Dispatchers.IO) {
//                val response = repository.getEverything()
//                _everythingList.value = response
//            }
//        }
    }
}