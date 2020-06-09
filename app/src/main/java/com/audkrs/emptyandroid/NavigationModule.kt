package com.audkrs.emptyandroid

import com.audkrs.emptyandroid.main.MainNavigation
import dagger.Module
import dagger.Provides

@Module
class NavigationModule {
  @Provides
  fun provideMainNavigation() = MainNavigation(R.id.main_fragment_container)
}
