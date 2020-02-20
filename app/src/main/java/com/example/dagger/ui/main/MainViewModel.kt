package com.example.dagger.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.dagger.network.NewsFeedApi
import javax.inject.Inject

class MainViewModel @Inject constructor(newsFeedApi: NewsFeedApi): ViewModel() {

    init {
        Log.e("----", " Main view model working ")

        if (newsFeedApi != null) {
            Log.e("----", " newsFeedApi working")
        } else {
            Log.e("----", " newsFeedApi NOT working")
        }
    }
}
