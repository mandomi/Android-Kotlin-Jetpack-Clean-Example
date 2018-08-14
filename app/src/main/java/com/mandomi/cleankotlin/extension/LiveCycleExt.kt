package com.mandomi.cleankotlin.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.mandomi.cleankotlin.ui.base.model.Resource

fun <T : Any, L : LiveData<Resource<T>>> LifecycleOwner.observe(liveData: L, body: (Resource<T>?) -> Unit) =
        liveData.observe(this, Observer(body))