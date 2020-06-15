package com.audkrs.emptyandroid.main

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
internal abstract class BazingaModule {
  @Binds
  abstract fun provideBazinga(bazinga: BazingaImpl): Bazinga
}
