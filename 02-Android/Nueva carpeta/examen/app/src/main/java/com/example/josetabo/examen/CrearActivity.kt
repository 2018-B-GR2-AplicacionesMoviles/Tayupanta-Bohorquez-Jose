package com.example.josetabo.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_crear.*

class CrearActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear)

        btn_cancelar.setOnClickListener{
            cancelar()
        }
        btn_guardar.setOnClickListener{registrarAutor()}
    }

    fun cancelar(){

        val intent = Intent( this, MainActivity::class.java)
        this.startActivity(intent)
        this.finish()
    }

    fun registrarAutor(){
        val nombre = editNombre.text.toString()
        val apellido = editApellido.text.toString()
        val fechaNacimiento = editFechaNa.text.toString()
        val numLibros = editNumeroLibros.text.toString()
        val ecuatoriano = editEcuatoriano.text.toString()

        var autor = Autores(nombre, apellido, fechaNacimiento,numLibros, ecuatoriano)
       //BaseDatosAutores.getList()


        BaseDatosAutores.insertarAutor(autor)
        Toast.makeText(this,"Autor registrado con exito", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)


    }
}
