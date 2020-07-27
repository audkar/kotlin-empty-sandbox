package com.audkrs.emptyandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.libraries.maps.SupportMapFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    (supportFragmentManager.findFragmentById(R.id.maps) as SupportMapFragment).getMapAsync {
      it.setOnMapClickListener {  }
    }
  }
}
