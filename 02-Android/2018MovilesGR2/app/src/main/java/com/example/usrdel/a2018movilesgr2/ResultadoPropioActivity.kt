package com.example.usrdel.a2018movilesgr2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado_propio.*

class ResultadoPropioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_propio)
        btnEnviarNombreApellido.setOnClickListener{
            this.devolverRespuesta()
        }
    }

    fun devolverRespuesta(){
        val nombre = editNombre.text
        val apellido = editApellido.text
        val intentRespuesta = Intent()
        intentRespuesta.putExtra("nombre", nombre)
        intentRespuesta.putExtra("apellido", apellido)

        this.setResult(Main2Activity.requestCodeNombreApellido,intentRespuesta)

        this.finish()

    }
}
