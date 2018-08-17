package com.mandomi.cleankotlin.ui.movie.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandomi.cleankotlin.databinding.ItemMovieBinding
import com.mandomi.cleankotlin.ui.listener.RecyclerItemClickListener
import com.mandomi.cleankotlin.ui.movie.MovieItem

class MoviesAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    var onItemClickListener: RecyclerItemClickListener<MovieItem>? = null

    var items: ArrayList<MovieItem> = arrayListOf()
        set(value) {
            val currentSize = items.size
            field = value
            if (currentSize == 0) {
                notifyDataSetChanged()
            } else {
                notifyItemRangeInserted(currentSize - 1, value.size)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val viewHolder = MovieViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context)))
        viewHolder.onItemClickListener = this@MoviesAdapter.onItemClickListener
        return viewHolder

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(items[position])
    }
}