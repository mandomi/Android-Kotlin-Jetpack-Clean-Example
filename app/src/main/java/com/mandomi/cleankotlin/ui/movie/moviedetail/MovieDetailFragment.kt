package com.mandomi.cleankotlin.ui.movie.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mandomi.cleankotlin.R
import com.mandomi.cleankotlin.databinding.FragmentMovieDetailBinding
import com.mandomi.cleankotlin.extension.createViewModel
import com.mandomi.cleankotlin.extension.observe
import com.mandomi.cleankotlin.ui.base.BaseFragment
import com.mandomi.cleankotlin.ui.base.model.Resource
import com.mandomi.cleankotlin.ui.base.model.ResourceState
import com.mandomi.cleankotlin.ui.movie.MovieItem

class MovieDetailFragment : BaseFragment() {
    private lateinit var viewModel: MovieDetailViewModel
    private lateinit var binding: FragmentMovieDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_detail, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = createViewModel(viewModelFactory) {
            observe(getData(), ::handleResourceState)
        }
        viewModel.load(MovieDetailFragmentArgs.fromBundle(arguments).movieId)
    }

    private fun handleResourceState(resource: Resource<MovieItem>?) {
        resource?.let {
            when (resource.resourceState) {
                ResourceState.SUCCESS -> {
                    binding.loading.visibility = View.GONE
                    binding.detailGroup.visibility = View.VISIBLE
                    showData(resource.data!!)
                }
                ResourceState.LOADING -> {
                    binding.loading.visibility = View.VISIBLE
                    binding.detailGroup.visibility = View.GONE
                }
                ResourceState.ERROR -> {
                }
            }
        }
    }

    private fun showData(item: MovieItem) {
        binding.movie = item
        binding.executePendingBindings()
    }
}