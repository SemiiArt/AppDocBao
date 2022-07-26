package com.tuyenhoang.appdocbao.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tuyenhoang.appdocbao.test.ModelSub
import com.tuyenhoang.appdocbao.databinding.IconSubBinding

class SubAdapter : RecyclerView.Adapter<SubAdapter.SubViewHolder> {
    private var iSub: ISub

    constructor(iSub: ISub) {
        this.iSub = iSub
    }

    class SubViewHolder : RecyclerView.ViewHolder {
        val binding: IconSubBinding

        constructor(binding: IconSubBinding) : super(binding.root) {
            this.binding = binding
        }
    }

    interface ISub {
        fun getCount(): Int
        fun getItem(position: Int): ModelSub
        fun setClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubViewHolder {
        return SubViewHolder(
            IconSubBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SubViewHolder, position: Int) {
        holder.binding.dataSub = iSub.getItem(position)
        holder.itemView.setOnClickListener {
            iSub.setClick(position)
        }
    }

    override fun getItemCount(): Int {
        return iSub.getCount()
    }
}