package com.audkrs.emptyandroid.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.audkrs.emptyandroid.main.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

  @Inject
  internal lateinit var bazinga: Bazinga

  @Inject
  internal lateinit var navigation: MainNavigation

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View = MainFragmentBinding.inflate(inflater, container, false).root

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    with(MainFragmentBinding.bind(view)) {
      mainText.text = "MainFragment: ${bazinga.haaa()}"
      mainGoNext.setOnClickListener {
        parentFragmentManager.commit {
          replace(navigation.containerId, SecondaryFragment())
          addToBackStack(null)
        }
      }
    }
  }

}
