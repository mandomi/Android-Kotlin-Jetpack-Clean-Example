package com.mandomi.cleankotlin.di.module

import android.content.Context
import com.mandomi.cleankotlin.domain.executer.PostExecutionThread
import com.mandomi.cleankotlin.domain.executer.UseCaseExecutor
import com.mandomi.cleankotlin.executer.ExecutorThread
import com.mandomi.cleankotlin.executer.UIThread
import com.mandomi.cleankotlin.core.CleanKotlinApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: CleanKotlinApplication): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideUseCaseExecutor(): UseCaseExecutor = ExecutorThread()

    @Provides
    @Singleton
    fun providePostExecutionThread(): PostExecutionThread = UIThread()
}