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

class FalloActivity : AppCompatActivity() {

    lateinit var option: Spinner
    lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fallo)

        option = findViewById(R.id.spinnerSector) as Spinner
        result = findViewById(R.id.guardaSector) as TextView

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

        btn_guardarDanio.setOnClickListener{
            volverInicio()
        }
    }

    fun volverInicio(){
        val intenVolver = Intent(this, InicioActivity::class.java)
        this.startActivity(intenVolver)
        this.finish()
    }
}
