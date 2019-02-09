package com.example.josetabo.proyecto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registrar.*

class RegistrarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        btn_RegisInicio.setOnClickListener{
            irInicio()
        }
    }

    fun irInicio(){
        val intenteInicio = Intent(this, InicioActivity::class.java)
        this.startActivity(intenteInicio)
        this.finish()
    }
}
