package com.example.tut_bep_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        val imageView = findViewById<ImageView>(R.id.mainimg)
        val textView = findViewById<TextView>(R.id.name)
        imageView.setImageResource(intent.getIntExtra("img",0))
        textView.text = intent.getStringExtra("name")

        val arrow = findViewById<ImageView>(R.id.arrow)
        arrow.setOnClickListener {
            finish()
        }
    }
}