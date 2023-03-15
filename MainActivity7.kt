package com.example.tut_bep_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        var catbtn = findViewById<TextView>(R.id.cat)
        var dogbtn = findViewById<TextView>(R.id.dog)
        val bf = BlankFragment();
        val bf2 = BlankFragment2();

        catbtn.setOnClickListener{

            supportFragmentManager.fragments.forEach {
                supportFragmentManager.beginTransaction().remove(it).commit()
            }

            supportFragmentManager
                .beginTransaction()
                .add(R.id.frame, bf)

                .commit()
        }

        dogbtn.setOnClickListener{
            if(bf2.isAdded){
                supportFragmentManager
                    .beginTransaction()
                    .remove(bf2)
                    .commit()
            }
            if(bf.isAdded){
                supportFragmentManager
                    .beginTransaction()
                    .remove(bf)
                    .commit()
            }
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frame, bf2)
                .commit()
        }

    }



}