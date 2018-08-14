package com.mandomi.cleankotlin.ui.movies

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mandomi.cleankotlin.R
import com.mandomi.cleankotlin.extension.createViewModel
import com.mandomi.cleankotlin.extension.observe
import com.mandomi.cleankotlin.ui.base.BaseActivity
import com.mandomi.cleankotlin.ui.base.model.Resource
import com.mandomi.cleankotlin.ui.base.model.ResourceState
import com.mandomi.cleankotlin.ui.listener.RecyclerItemClickListener
import kotlinx.android.synthetic.main.activity_movies.*

class MoviesActivity : BaseActivity(), RecyclerItemClickListener<MovieItem> {

    private lateinit var viewModel: MoviesViewModel
    private val adapter: MoviesAdapter = MoviesAdapter()


    override fun onClick(t: MovieItem) {
        Toast.makeText(this, t.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        init()
        viewModel = createViewModel(viewModelFactory) {
            observe(getData(), ::handleResourceState)
        }
        viewModel.load()
    }

    private fun init() {

        with(adapter) {
            onItemClickListener = this@MoviesActivity
        }

        with(recyclerView) {
            setHasFixedSize(false)
            adapter = this@MoviesActivity.adapter
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
