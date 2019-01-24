package com.example.usrdel.fragmentos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            this.irFragmentos()
        }

    }
    fun irFragmentos(){
        val intentFragmentos = Intent(this, Fragmentos::class.java)
        this.startActivity(intentFragmentos)
    }
}
