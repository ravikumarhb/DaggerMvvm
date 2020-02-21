package com.example.dagger.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.dagger.network.NewsFeedApi
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

// viewmodel for main fragment
class MainViewModel @Inject constructor(var newsFeedApi: NewsFeedApi) :
    ViewModel() {

    // using coroutines instead of Rxjava
    val dataFun = liveData(Dispatchers.IO) {
        val data = newsFeedApi.getNewsItems()
        emit(data)
    }

}
