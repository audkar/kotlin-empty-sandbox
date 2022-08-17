package com.audkrs.emptyandroid

import com.audkrs.emptyandroid.main.MainNavigation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class NavigationModule {
  @Provides
  fun provideMainNavigation() = MainNavigation(R.id.content)
}
