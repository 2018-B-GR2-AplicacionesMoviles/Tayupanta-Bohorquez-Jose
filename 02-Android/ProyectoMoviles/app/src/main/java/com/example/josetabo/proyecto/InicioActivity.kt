package com.example.josetabo.proyecto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_inicio.*
import java.util.*

class InicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        btn_irGuardarLectura.setOnClickListener{
            irRegistrarLectura()
        }

        btn_registrarDanio.setOnClickListener{
            irRegistrarDanio()
        }

        btn_listarLecturas.setOnClickListener{
            irListaLecturas()
        }

        btn_buscar_por_voz.setOnClickListener {
                v:  View? -> getSpeechInput(v)
        }
    }

    fun irRegistrarLectura(){
        val intent = Intent(this, LecturaActivity::class.java)
        this.startActivityForResult(intent, requestCodeInsertar)

    }

    fun irRegistrarDanio(){
        val intent = Intent(this, FalloActivity::class.java)
        this.startActivity(intent)
        this.finish()
    }

    fun irListaLecturas(){
        val intent = Intent(this, ListarLecturasActivity::class.java)
        this.startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode){
            requestCodeInsertar -> {
                when (resultCode) {
                    RESULT_OK -> {
                        ingresarLectura(data!!.getStringExtra("sector"), data!!.getStringExtra("medidor"),
                            data!!.getStringExtra("nombre"), data!!.getStringExtra("numCasa"),data!!.getStringExtra("lecturaMedidor"))
                    }
                    RESULT_CANCELED -> {
                        Log.i("error", "Error")
                    }
                }
            }
            else -> {
                Log.e("indefinido", "indefinido")
            }
        }
    }

    fun ingresarLectura (sector: String, medidor:String, nombre: String, numCasa:String, lecturaMedidor: String):Unit{
        val nuevaLectura: Lectura = Lectura(sector,medidor, nombre, numCasa, lecturaMedidor)
        Datos.Lectura.add(nuevaLectura)
    }

    companion object {
        val requestCodeInsertar = 101
    }

    fun getSpeechInput (view: View?){
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        if (intent.resolveActivity(getPackageManager()) !=null){
            startActivityForResult(intent,10)
        }
        else{
            Toast.makeText(this,"\n" +
                    "Su dispositivo no es compatible con la entrada de voz", Toast.LENGTH_SHORT ).show()
        }
    }

}
