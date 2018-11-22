package com.example.usrdel.a2018movilesgr2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class IntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        val usuario = intent.getParcelableExtra<Usuario>("usuario")
        val mascota = intent.getParcelableExtra<Mascota>("mascota")
        Log.i("parcelable", "Usuario: ${usuario} Mascota: ${mascota}")

    }
}
