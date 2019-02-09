package com.example.josetabo.proyecto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_editar_lectura.*

class EditarLecturaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_lectura)

        val lectura = intent.getParcelableExtra<Lectura?>("casa")
        val pos = intent.getIntExtra("pos", 0)

        if (lectura != null) {
            mostrarCampos(lectura)
        }

        btn_Actualizar.setOnClickListener{
            actualizarLectura(textMostrarSector.text.toString(),textMostrarMedidor.text.toString(),editCambiarNombre.text.toString(),editCambiarNumCasa.text.toString(),
                editCambiarLectura.text.toString(), pos)
            irVolverLista()
        }
    }

    private fun mostrarCampos(lectura: Lectura) {
        textMostrarSector.setText(lectura.sector)
        textMostrarMedidor.setText(lectura.medidor)
        editCambiarNombre.setText(lectura.nombre)
        editCambiarNumCasa.setText(lectura.numCasa)
        editCambiarLectura.setText(lectura.lecturaMedidor)

    }

    fun irVolverLista(){
        val intent = Intent(this, ListarLecturasActivity::class.java)
        this.startActivity(intent)
        this.finish()
    }

    fun actualizarLectura (sector: String, medidor:String, nombre: String, numCasa:String, lecturaMedidor: String, pos: Int):Unit{
        val nuevaLectura: Lectura = Lectura(sector,medidor, nombre, numCasa, lecturaMedidor)
        Datos.Lectura[pos] = nuevaLectura
    }
}
