package com.example.josetabo.deber

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_dos.*

class ActivityDos : AppCompatActivity() {

    var usuario:String = " "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dos)

        this.capturarDatos()
        txtRecibeUser.text = "Bienvenido: $usuario"
    }
    fun capturarDatos(){
        this.usuario= intent.getStringExtra("usuario")
        Toast.makeText(this, "Usuario aceptado", Toast.LENGTH_LONG).show()
    }
}
