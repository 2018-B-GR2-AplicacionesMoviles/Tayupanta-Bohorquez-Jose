package com.example.usrdel.a2018movilesgr2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_button.*

class ButtonActivity : AppCompatActivity() {

    var nombre: String = ""
    var apellido: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)
        this.capturaDatos()
        act_but_nombre.text = "${this.nombre} ${this.apellido}"

        btn_enviar.setOnClickListener{
            enviarIntentCorreo()
        }

    }
    fun capturaDatos(){
        this. nombre = intent.getStringExtra("nombre")
        this.apellido = intent.getStringExtra("apellido")
    }

    fun enviarIntentCorreo(){
        val correo = correoEdit.text
        val subject = subjectEdit.text
        val text = textEdit.text

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/html"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(correo, "jose@jose.com"))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, text)

        startActivity(intent)

    }
}
