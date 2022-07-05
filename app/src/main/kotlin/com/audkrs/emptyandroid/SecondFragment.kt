package com.audkrs.emptyandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SecondFragment: BottomSheetDialogFragment() {

    init {
        Thread.sleep(500)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = TextView(inflater.context).apply { text = "example" }

    override fun onResume() {
        super.onResume()
        println("=== SecondFragment onResume")
    }

    override fun onPause() {
        super.onPause()
        println("=== SecondFragment onPause")
    }
}
