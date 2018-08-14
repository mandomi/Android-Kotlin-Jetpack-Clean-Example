package com.mandomi.cleankotlin.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mandomi.cleankotlin.core.ViewModelFactory
import com.mandomi.cleankotlin.di.annotation.ViewModelKey
import com.mandomi.cleankotlin.ui.movies.MoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    abstract fun bindsCategoryViewModel(categoryViewModel: MoviesViewModel): ViewModel
}