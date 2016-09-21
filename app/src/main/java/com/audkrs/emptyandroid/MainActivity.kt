package com.audkrs.emptyandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "Hello world!", Toast.LENGTH_SHORT).show()
        text_view.setOnClickListener(View.OnClickListener { /*nothing here*/ });
    }
}
