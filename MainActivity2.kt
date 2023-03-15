package com.example.tut_bep_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var button = findViewById<Button>(R.id.button)
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra("name", "Anjali")
        intent.putExtra("numb", 100)

        button.setOnClickListener{
            startActivity(intent)
        }

    }
}