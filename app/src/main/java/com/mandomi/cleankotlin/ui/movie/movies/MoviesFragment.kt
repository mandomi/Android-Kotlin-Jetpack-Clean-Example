package com.mandomi.cleankotlin.ui.movie.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mandomi.cleankotlin.R
import com.mandomi.cleankotlin.extension.createViewModel
import com.mandomi.cleankotlin.extension.observe
import com.mandomi.cleankotlin.ui.base.BaseFragment
import com.mandomi.cleankotlin.ui.base.model.Resource
import com.mandomi.cleankotlin.ui.base.model.ResourceState
import com.mandomi.cleankotlin.ui.listener.RecyclerItemClickListener
import com.mandomi.cleankotlin.ui.movie.MovieItem
import kotlinx.android.synthetic.main.fragment_movies.*

class MoviesFragment : BaseFragment(), RecyclerItemClickListener<MovieItem> {

    private lateinit var viewModel: MoviesViewModel
    private val adapter: MoviesAdapter = MoviesAdapter()


    override fun onClick(t: MovieItem) {
        val direction = MoviesFragmentDirections.ActionMoviesFragmentToMovieDetailFragment(t.id)
        view?.findNavController()?.navigate(direction)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = createViewModel(viewModelFactory) {
            observe(getData(), ::handleResourceState)
        }
        viewModel.load()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

        with(adapter) {
            onItemClickListener = this@MoviesFragment
        }

        with(recyclerView) {
            setHasFixedSize(false)
            adapter = this@MoviesFragment.adapter
            setPadding(0, 0, 0, 0)
            itemAnimator?.changeDuration = 0
            layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        }
    }

    private fun handleResourceState(resource: Resource<List<MovieItem>>?) {
        resource?.let {
            when (resource.resourceState) {
                ResourceState.SUCCESS -> {
                    loading.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE
                    showData(resource.data!!)
                }
                ResourceState.LOADING -> {
                    loading.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                ResourceState.ERROR -> {
                }
            }
        }
    }

    private fun showData(items: List<MovieItem>) {
        adapter.items = ArrayList(items)
    }
}
