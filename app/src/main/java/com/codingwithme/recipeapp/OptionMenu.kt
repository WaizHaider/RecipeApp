package com.codingwithme.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_option_menu.*

class OptionMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option_menu)
        btnGetStarted.setOnClickListener {
            val intent = Intent(this, SQLDatabase::class.java)
            // start your next activity
            startActivity(intent)
        }
        btnsearch.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            // start your next activity
            startActivity(intent)
        }
        btnSearchBy.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}