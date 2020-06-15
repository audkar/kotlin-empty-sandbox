package com.audkrs.emptyandroid.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment) {

  @Inject
  internal lateinit var bazinga: Bazinga
  @Inject
  internal lateinit var navigation: MainNavigation

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    main_text.text = "MainFragment: ${bazinga.haaa()}"
    main_go_next.setOnClickListener {
      parentFragmentManager.commit {
        replace(navigation.containerId, SecondaryFragment())
        addToBackStack(null)
      }
    }
  }

}
