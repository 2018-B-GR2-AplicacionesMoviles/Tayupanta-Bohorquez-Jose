package com.example.josetabo.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_crear.setOnClickListener{
            irCrear()
        }
        btn_listar.setOnClickListener{
            irListar()
        }
    }

    fun irCrear(){
        val intent = Intent(this, CrearActivity::class.java)
        this.startActivity(intent)
    }

    fun irListar(){
        val intentListar = Intent(this, ListarActivity::class.java)
        this.startActivity(intentListar)
    }

}
