package com.example.tut_bep_android

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val string: String = getString(R.string.hello)
        val tealColor = getColor(R.color.teal_700)

         val name = intent.getStringExtra("name")
         val number = intent.getIntExtra("numb", 0)

        var text1 = findViewById<TextView>(R.id.text1)
        var text2 = findViewById<TextView>(R.id.text2)
        text1.text = name
        text2.text = number.toString()

        text1.textSize= 20f

        text1.setTextColor(Color.YELLOW)
        text2.setTextColor(tealColor)
        Log.w("_______","a")
        Log.w("hello",string)
    }
}