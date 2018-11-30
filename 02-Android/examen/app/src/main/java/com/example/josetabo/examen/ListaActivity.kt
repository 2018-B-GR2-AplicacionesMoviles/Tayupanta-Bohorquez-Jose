package com.example.josetabo.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import java.util.ArrayList

class ListaActivity : AppCompatActivity() {

    lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        listView = findViewById(R.id.lista)

        val arregloPaciente = ArrayList<Paciente>();

        val pacienteUno = Paciente(
            "juan",
            "diabetes",
            "insulina"
        )
        val pacienteDos = Paciente(
            "juan",
            "diabetes",
            "insulina"
        )
        val pacienteTres = Paciente(
            "juan",
            "diabetes",
            "insulina"
        )

        //val pacienteDos = Paciente()
        val arreglo = arrayOf(pacienteUno, pacienteDos, pacienteTres)

        listView.adapter = ArrayAdapter<Paciente>(this, android.R.layout.simple_list_item_1,arreglo)

        listView.setOnItemClickListener{adapterView, view, i, l ->
            val intent = Intent(this, ModificarActivity::class.java)
            this.startActivity(intent)
        }
    }


}
