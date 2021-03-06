package com.audkrs.emptyandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.audkrs.emptyandroid.databinding.ActivityMainBinding
import com.audkrs.emptyandroid.main.Bazinga
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var bazinga: Bazinga

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(ActivityMainBinding.inflate(layoutInflater)) {
            clickMe.setOnClickListener {
                helloText.text = bazinga.haaa()
            }
            setContentView(root)
        }
    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount > 0) {
           supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}
