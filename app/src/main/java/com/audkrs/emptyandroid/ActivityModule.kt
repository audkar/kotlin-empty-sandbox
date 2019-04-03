package com.audkrs.emptyandroid

import com.audkrs.emptyandroid.main.FragmentModule
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule : AndroidInjector<MainActivity> {
    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            FragmentModule::class
        ]
    )
    fun contributeMainActivityInjector(): MainActivity
}
