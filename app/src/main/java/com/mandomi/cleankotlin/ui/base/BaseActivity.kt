package com.mandomi.cleankotlin.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {
    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        Toast.makeText(this,"Basse", Toast.LENGTH_SHORT).show()
    }
}