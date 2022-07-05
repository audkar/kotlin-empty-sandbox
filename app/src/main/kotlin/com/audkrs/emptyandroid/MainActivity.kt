package com.audkrs.emptyandroid

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onBackPressed() {
        if (!findNavController(R.id.nav_host_fragment).popBackStack()) {
            super.onBackPressed()
        }
    }
}
