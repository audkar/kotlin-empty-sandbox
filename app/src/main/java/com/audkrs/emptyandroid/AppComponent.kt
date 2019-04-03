package com.audkrs.emptyandroid

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class
    ]
)
interface AppComponent : AndroidInjector<EmptyApp> {
    override fun inject(instance: EmptyApp)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance emptyApp: EmptyApp): AppComponent
    }
}
