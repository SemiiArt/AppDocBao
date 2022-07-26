package com.tuyenhoang.appdocbao.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tuyenhoang.appdocbao.test.ModelWebsite
import com.tuyenhoang.appdocbao.databinding.IconWebsiteBinding

class WebsiteAdapter : RecyclerView.Adapter<WebsiteAdapter.WebsiteViewHolder> {
    val iwebsite: IWebsite

    constructor(iWebsite: IWebsite) {
        this.iwebsite = iWebsite
    }

    class WebsiteViewHolder : RecyclerView.ViewHolder {
        val binding: IconWebsiteBinding

        constructor(binding: IconWebsiteBinding) : super(binding.root) {
            this.binding = binding
        }
    }

    interface IWebsite {
        fun getCount(): Int
        fun getItem(position: Int): ModelWebsite
        fun setClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebsiteViewHolder {
        return WebsiteViewHolder(
            IconWebsiteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: WebsiteViewHolder, position: Int) {
        holder.binding.dataWeb = iwebsite.getItem(position)
        holder.itemView.setOnClickListener {
            iwebsite.setClick(position)
        }
    }

    override fun getItemCount(): Int {
        return iwebsite.getCount()
    }
}