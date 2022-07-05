package com.audkrs.emptyandroid

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController

class FirstFragment : Fragment(R.layout.first_fragment) {

    override fun onResume() {
        super.onResume()

        println("=== FirstFragment onResume")
        val navDestLifecycle = findNavController().currentBackStackEntry!!.lifecycle

        requireView().findViewById<View>(R.id.btn_navigate).setOnClickListener {
            logClickEvent(navDestLifecycle)
            findNavController().navigate(FirstFragmentDirections.actionFirstToSecond())
        }
    }

    override fun onPause() {
        super.onPause()
        println("=== FirstFragment onPause")

        requireView().findViewById<View>(R.id.btn_navigate).setOnClickListener(null)
    }

    private fun logClickEvent(navDestLifecycle: Lifecycle) {
        val currentDestination = findNavController().currentDestination!!.label
        val fragmentState = lifecycle.currentState
        val viewLifeState = viewLifecycleOwner.lifecycle.currentState
        val navDestState = navDestLifecycle.currentState
        println(buildString {
            append("=== FirstFragment click navigate.")
            append(" isResumed: $isResumed")
            append(", currentDestination: $currentDestination")
            append(", fragmentState: $fragmentState")
            append(", viewState: $viewLifeState")
            append(", navDestState: $navDestState")
        })
    }

}
