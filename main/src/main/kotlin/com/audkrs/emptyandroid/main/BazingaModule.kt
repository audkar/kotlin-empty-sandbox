package com.audkrs.emptyandroid.main

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class BazingaModule {
  @Binds
  abstract fun provideBazinga(bazinga: BazingaImpl): Bazinga
}
