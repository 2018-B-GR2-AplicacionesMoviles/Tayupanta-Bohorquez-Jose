package com.example.josetabo.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        this.startActivityForResult(intent, requestCodeInsertar)

    }

    fun irListar(){
        val intentListar = Intent(this, ListarActivity::class.java)
        this.startActivity(intentListar)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode){
            requestCodeInsertar -> {
                when (resultCode) {
                    RESULT_OK -> {
                        ingresarAutor(data!!.getStringExtra("nombre"), data!!.getStringExtra("apellido"),
                            data!!.getStringExtra("fechaNacimiento"), data!!.getStringExtra("numLibros"),data!!.getStringExtra("ecuatoriano"))
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

    companion object {
        val requestCodeInsertar = 101
    }

    fun ingresarAutor (nombre: String, apellido: String, fechaNacimiento: String, numLibros:String, ecuatoriano: String):Unit{
        val nuevaLectura: Autores = Autores(nombre, apellido, fechaNacimiento, numLibros, ecuatoriano)
        Datos.Autores.add(nuevaLectura)
    }

}
