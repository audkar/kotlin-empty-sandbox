package com.audkrs.emptyandroid.main

import dagger.Binds
import dagger.Module

@Module
internal interface InternalModule {
    @Binds
    fun bindsBazinga(bazingaImpl: BazingaImpl): Bazinga
}
