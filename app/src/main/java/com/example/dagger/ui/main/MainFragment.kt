package com.example.dagger.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger.R
import com.example.dagger.adapter.NewsAdapter
import com.example.dagger.databinding.MainFragmentBinding
import com.example.dagger.utils.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

// Entry Fragment when App launched
class MainFragment : DaggerFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: MainFragmentBinding

    private lateinit var newsAdapter: NewsAdapter

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // create adapter, pass url to load based on item selected
        newsAdapter = NewsAdapter(NewsAdapter.NewsClick {
            var bundle = bundleOf("newsitem" to it.url)
            findNavController().navigate(R.id.action_main_fragment_to_detail_fragment, bundle)
        })

        // configure recycler view
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = newsAdapter
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel =
            ViewModelProviders.of(this, viewModelProviderFactory).get(MainViewModel::class.java)

        // Populate the adapter based on response from API call
        viewModel.dataFun.observe(viewLifecycleOwner, Observer { items ->
            items?.apply {
                newsAdapter.newsList = items.articles
            }
        })

    }

}
