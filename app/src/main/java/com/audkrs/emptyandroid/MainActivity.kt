package com.audkrs.emptyandroid

import android.os.Bundle
import android.view.View
import com.audkrs.emptyandroid.main.Bazinga
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var bazinga: Bazinga

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickMe(view: View) {
        hello_text.text = bazinga.haaa()
    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount > 0) {
           supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}
