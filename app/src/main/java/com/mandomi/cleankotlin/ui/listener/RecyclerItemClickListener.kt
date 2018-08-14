package com.mandomi.cleankotlin.ui.listener

interface RecyclerItemClickListener<in T> {
    fun onClick(t: T)
}