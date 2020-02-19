package com.example.dagger.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {

    init {
        Log.e("----", " Main view model working")
    }
}
