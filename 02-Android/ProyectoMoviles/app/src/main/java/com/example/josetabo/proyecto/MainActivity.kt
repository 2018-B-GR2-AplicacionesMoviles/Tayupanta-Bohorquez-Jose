package com.example.josetabo.proyecto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_ingresar.setOnClickListener{
            irLogin()
        }
    }

    fun irLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        this.startActivity(intent)
        this.finish()
    }
}
