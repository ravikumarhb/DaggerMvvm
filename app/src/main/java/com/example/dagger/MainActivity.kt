package com.example.dagger

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.example.dagger.ui.main.DetailFragment
import com.example.dagger.utils.ViewModelProviderFactory
import com.example.dagger.ui.main.MainFragment
import com.example.dagger.ui.main.MainViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var data: String

//    @Inject
//    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    //lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

//        mainViewModel =
//            ViewModelProviders.of(this, viewModelProviderFactory).get(MainViewModel::class.java)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DetailFragment.newInstance())
                .commitNow()
        }
    }

}
