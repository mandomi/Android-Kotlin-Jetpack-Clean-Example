package com.mandomi.cleankotlin.di.component

import com.mandomi.cleankotlin.di.module.AppModule
import com.mandomi.cleankotlin.di.module.ViewModelModule
import com.mandomi.cleankotlin.core.CleanKotlinAppication
import com.mandomi.cleankotlin.di.module.NetworkModule
import com.mandomi.cleankotlin.ui.movies.MoviesModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ViewModelModule::class,
    NetworkModule::class,
    MoviesModule::class
])
interface AppComponent : AndroidInjector<CleanKotlinAppication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<CleanKotlinAppication>()
}