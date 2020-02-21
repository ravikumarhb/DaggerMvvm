package com.example.dagger.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger.R
import com.example.dagger.databinding.NewsItemViewBinding
import com.example.dagger.network.NetworkNews

class NewsAdapter(val callback: NewsClick) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

     var newsList: List<NetworkNews> = emptyList()

    set(value) {
            field = value
            notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val binding: NewsItemViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            NewsViewHolder.LAYOUT,
            parent,
            false
        )

        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.viewBinding.also {
            it.item = newsList.get(position)
            it.callback = callback
        }
    }

    class NewsViewHolder(val viewBinding: NewsItemViewBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        companion object {
            @LayoutRes
            val LAYOUT = R.layout.news_item_view
        }
    }

    class NewsClick(val block: (NetworkNews) -> Unit) {
        fun onNewsClick(news: NetworkNews) {
            block(news)
        }
    }
}