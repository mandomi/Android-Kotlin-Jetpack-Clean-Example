package com.mandomi.cleankotlin.ui.movies

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.mandomi.cleankotlin.BR
import com.mandomi.cleankotlin.ui.listener.RecyclerItemClickListener

class MovieViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    var onItemClickListener: RecyclerItemClickListener<MovieItem>? = null

    fun bind(item: MovieItem) {
        binding.setVariable(BR.itemData, item)
        onItemClickListener?.let {
            binding.setVariable(BR.itemClickListener, onItemClickListener)
        }
        binding.executePendingBindings()
    }
}