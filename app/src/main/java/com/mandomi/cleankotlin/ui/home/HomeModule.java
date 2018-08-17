package com.mandomi.cleankotlin.ui.home;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class HomeModule {

    @ContributesAndroidInjector
    abstract HomeActivity contributeHomeActivity();
}