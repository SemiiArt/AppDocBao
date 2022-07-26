package com.tuyenhoang.appdocbao.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tuyenhoang.appdocbao.test.ModelMainNav
import com.tuyenhoang.appdocbao.databinding.IconMainNavBinding


class MainNavAdapter : RecyclerView.Adapter<MainNavAdapter.MainNavViewHolder> {
    val iMainNav: IMainNav

    constructor(iMainNav: IMainNav) {
        this.iMainNav = iMainNav
    }

    class MainNavViewHolder : RecyclerView.ViewHolder {
        val binding: IconMainNavBinding

        constructor(binding: IconMainNavBinding) : super(binding.root) {
            this.binding = binding
        }
    }

    interface IMainNav {
        fun getCount(): Int
        fun getItem(position: Int): ModelMainNav
        fun setClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainNavViewHolder {
        return MainNavViewHolder(
            IconMainNavBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainNavViewHolder, position: Int) {
        holder.binding.dataMainNav = iMainNav.getItem(position)
        holder.itemView.setOnClickListener {
            iMainNav.setClick(position)
        }
    }

    override fun getItemCount(): Int {
        return iMainNav.getCount()
    }
}