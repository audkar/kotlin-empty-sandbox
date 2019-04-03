package com.audkrs.emptyandroid.main

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [InternalModule::class])
interface FragmentModule {
    @FragmentScope
    @ContributesAndroidInjector
    fun contributesMainFragment(): MainFragment

}
