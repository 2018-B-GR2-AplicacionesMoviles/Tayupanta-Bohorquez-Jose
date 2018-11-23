package com.example.usrdel.listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.lista)

        val perros = arrayOf("labrador","husky siberiano","pastor aleman")

        listView.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, perros)

        listView.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(applicationContext, "escogiste "+perros[i],Toast.LENGTH_LONG).show()
        }
    }
}
