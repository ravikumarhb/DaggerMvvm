package com.example.dagger.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.dagger.R
import com.example.dagger.databinding.DetailFragmentBinding
import com.example.dagger.utils.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class DetailFragment : DaggerFragment() {

    @Inject
    lateinit var data: String

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var viewModel: DetailViewModel

    var urlToLoad: String? = ""

    private lateinit var web: WebView

    private lateinit var binding: DetailFragmentBinding


    companion object {
        fun newInstance() = DetailFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.e("-----", data)

        binding = DataBindingUtil.inflate(
            LayoutInflater.from(container?.context),
            R.layout.detail_fragment,
            container,
            false
        )


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =
            ViewModelProviders.of(this, viewModelProviderFactory).get(DetailViewModel::class.java)

        urlToLoad = arguments?.getString("newsitem")
    }

    override fun onResume() {
        super.onResume()

        web = binding.webview
        web.loadUrl(urlToLoad)
        web.webViewClient = WebViewClient()
    }


}
