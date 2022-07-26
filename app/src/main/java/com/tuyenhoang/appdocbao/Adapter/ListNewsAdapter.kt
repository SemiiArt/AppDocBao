package com.tuyenhoang.appdocbao.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tuyenhoang.appdocbao.test.ModelListNews
import com.tuyenhoang.appdocbao.databinding.IconListNewsBinding

class ListNewsAdapter : RecyclerView.Adapter<ListNewsAdapter.ListNewsViewHolder> {
    var iListNews: IListNews

    constructor(iListNews: IListNews) {
        this.iListNews = iListNews
    }

    class ListNewsViewHolder : RecyclerView.ViewHolder {
        val binding: IconListNewsBinding

        constructor(binding: IconListNewsBinding) : super(binding.root) {
            this.binding = binding
        }
    }

    interface IListNews {
        fun getCount(): Int
        fun getItem(position: Int): ModelListNews
        fun setClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNewsViewHolder {
        return ListNewsViewHolder(
            IconListNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListNewsViewHolder, position: Int) {
        holder.binding.dataListNews = iListNews.getItem(position)
        holder.itemView.setOnClickListener {
            iListNews.setClick(position)
        }
    }

    override fun getItemCount(): Int {
        return iListNews.getCount()
    }
}