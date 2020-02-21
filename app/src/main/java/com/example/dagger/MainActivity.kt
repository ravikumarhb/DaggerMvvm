package com.example.dagger

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

// Starting activity when application launched supporting dagger
class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

}
