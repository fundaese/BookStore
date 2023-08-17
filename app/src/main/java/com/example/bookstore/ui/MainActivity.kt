package com.example.bookstore.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bookstore.MainApplication
import com.example.bookstore.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainApplication.provideRetrofit(this)
    }
}