package com.example.josetabo.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_inicio.*

class InicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        btn_crear.setOnClickListener{
            irPantallaCrear()
        }

        btn_listar.setOnClickListener{
            irPantallaListar()
        }
    }

    fun irPantallaCrear() {
        // INTENT
        val intentCrear = Intent(this, CrearActivity::class.java)
        this.startActivity(intentCrear)
    }

    fun irPantallaListar(){
        val intentListar = Intent(this, ListaActivity::class.java)
        this.startActivity(intentListar)
    }
}
