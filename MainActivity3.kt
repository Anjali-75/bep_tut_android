package com.example.tut_bep_android

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)


        var button = findViewById<Button>(R.id.btn)
        val intent = Intent(Intent.ACTION_DIAL)
        intent.setData(Uri.parse("tel:1234567890"))

        button.setOnClickListener {
            startActivity(intent);
        }
    }
}