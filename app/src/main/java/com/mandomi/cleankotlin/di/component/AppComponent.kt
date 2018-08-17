package com.mandomi.cleankotlin.di.component

import com.mandomi.cleankotlin.core.CleanKotlinApplication
import com.mandomi.cleankotlin.ui.home.HomeModule
import com.mandomi.cleankotlin.di.module.AppModule
import com.mandomi.cleankotlin.di.module.NetworkModule
import com.mandomi.cleankotlin.di.module.ViewModelModule
import com.mandomi.cleankotlin.ui.movie.MovieModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    HomeModule::class,
    ViewModelModule::class,
    NetworkModule::class,
    MovieModule::class
])
interface AppComponent : AndroidInjector<CleanKotlinApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<CleanKotlinApplication>()
}