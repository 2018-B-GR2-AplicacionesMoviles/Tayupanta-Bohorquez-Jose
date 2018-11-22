package com.example.usrdel.a2018movilesgr2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import kotlinx.android.synthetic.main.activity_button.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton_navegar
                .setOnClickListener {
                    /*
                    Log.i("navegacion","Hola")
                    Log.w("navegacion","Hola")
                    Log.d("navegacion","Hola")
                    Log.e("navegacion","Hola")
                    Log.v("navegacion","Hola")
                    */
                    this.irAPantallaDeBotones()
                }
        btnRespuesta.setOnClickListener{
            this.enviarIntentRespuesta()
        }
    }

    fun irAPantallaDeBotones() {
        // INTENT
        val intentIrABotones = Intent(this, ButtonActivity::class.java)
        intentIrABotones.putExtra("nombre","Jose")
        intentIrABotones.putExtra("apellido", "Tayupanta")
        this.startActivity(intentIrABotones)
    }

    fun enviarIntentRespuesta(){
        val intentRespuesta = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
        this.startActivityForResult(intentRespuesta,101)

    }
    fun irActividadIntent(){
        val intentActividadIntent = Intent(
                this, IntentActivity::class.java
        )
        val jose = Usuario(
                "Jose",
                27,
                Date(1991, 2, 15),
                12.00)
        val savage = Mascota(
                "savage",
                jose
        )
        intentActividadIntent.putExtra("usuario", jose)
        intentActividadIntent.putExtra("mascota", savage
        )
    }



}
