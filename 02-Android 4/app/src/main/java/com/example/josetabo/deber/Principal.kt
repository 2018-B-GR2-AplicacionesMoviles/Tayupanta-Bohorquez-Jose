package com.example.josetabo.deber

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_principal.*

class Principal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        btn_siguiente.setOnClickListener{
            this.irActivityDos()
        }
    }
    fun irActivityDos(){
        val intenUno = Intent(this, ActivityDos::class.java)
        var usuario:String = txtUser.text.toString()
        intenUno.putExtra("usuario", usuario)
        this.startActivity(intenUno)
    }


}
