package com.example.josetabo.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_crear.*
import java.util.*

class CrearActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear)

        btn_guardar.setOnClickListener{
            guardarVolver()
        }

        btn_cancelar.setOnClickListener{
            cancelar()
        }

    }

    fun guardarVolver(){
        val intentVolver = Intent(this, InicioActivity::class.java)

        this.startActivity(intentVolver)
    }

    fun cancelar(){
        val intentCancelar = Intent(this, InicioActivity::class.java)
        this.startActivity(intentCancelar)
    }
}
