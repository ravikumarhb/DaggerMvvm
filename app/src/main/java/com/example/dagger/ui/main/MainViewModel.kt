package com.example.dagger.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.dagger.network.NewsFeedApi
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import javax.inject.Inject

class MainViewModel @Inject constructor(var newsFeedApi: NewsFeedApi, var retrofit: Retrofit) :
    ViewModel() {

    val dataFun = liveData(Dispatchers.IO) {
        val data = newsFeedApi.getNewsItems()
        emit(data)
    }

}
