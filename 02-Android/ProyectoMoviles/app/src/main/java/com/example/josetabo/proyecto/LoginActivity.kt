package com.example.josetabo.proyecto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_registrar.setOnClickListener{
            irRegistrar()
        }

        btn_login.setOnClickListener{
            irIncio()
        }
    }

    fun irRegistrar(){
        val intentRegistro = Intent(this, RegistrarActivity::class.java)
        this.startActivity(intentRegistro)
        this.finish()
    }

    fun irIncio(){
        val intentoInicio = Intent(this, InicioActivity::class.java)
        this.startActivity(intentoInicio)
        this.finish()
    }
}
