package com.mandomi.cleankotlin.ui.base

import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {
    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory
}