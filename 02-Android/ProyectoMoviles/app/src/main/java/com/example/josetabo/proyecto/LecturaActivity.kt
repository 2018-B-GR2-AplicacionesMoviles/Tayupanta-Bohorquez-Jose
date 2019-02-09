package com.example.josetabo.proyecto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_fallo.*
import kotlinx.android.synthetic.main.activity_lectura.*

class LecturaActivity : AppCompatActivity() {

    lateinit var option: Spinner
    lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lectura)

        option = findViewById(R.id.spinSectores) as Spinner
        result = findViewById(R.id.textSector) as TextView

        val opciones = arrayOf("Oyambaro","Oyambarillo","San José")
        option.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opciones)

        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                result.text = "Escoja el sector"
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                result.text = opciones.get(position)
            }

        }
        btn_guardarLectura.setOnClickListener{
            guardarLectura()

        }
    }

    fun volverInicio(){
        val intenteVolver = Intent(this, InicioActivity::class.java)
        this.startActivity(intenteVolver)
        this.finish()
    }

    fun guardarLectura(){
        val sector = textSector.text.toString()
        val medidor = editMedidor.text.toString()
        val nombre = editNomCasa.text.toString()
        val numCasa = editNumCasa.text.toString()
        val lecturaMedidor = editLectura.text.toString()

        val intentRespuesta = Intent()

        intentRespuesta.putExtra("sector", sector)
        intentRespuesta.putExtra("medidor", medidor)
        intentRespuesta.putExtra("nombre", nombre)
        intentRespuesta.putExtra("numCasa", numCasa)
        intentRespuesta.putExtra("lecturaMedidor", lecturaMedidor)

        this.setResult(
            RESULT_OK,
            intentRespuesta
        )
        this.finish()
    }

}
