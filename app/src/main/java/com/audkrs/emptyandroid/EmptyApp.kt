package com.audkrs.emptyandroid

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class EmptyApp : DaggerApplication() {
    private val appComponent = DaggerAppComponent.factory().create(this)

    override fun applicationInjector(): AndroidInjector<EmptyApp> = appComponent
}
