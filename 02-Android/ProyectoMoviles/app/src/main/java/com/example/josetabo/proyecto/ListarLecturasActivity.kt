package com.example.josetabo.proyecto

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_editar_lectura.*
import kotlinx.android.synthetic.main.activity_lectura.*
import kotlinx.android.synthetic.main.activity_listar_lecturas.*

class ListarLecturasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_lecturas)
        listaLecturas.adapter = ArrayAdapter<Lectura>(
            this, android.R.layout.simple_expandable_list_item_1, Datos.Lectura)

        val intentEditar = Intent(this, EditarLecturaActivity::class.java)
        listaLecturas
            .onItemClickListener =
                object : AdapterView.OnItemClickListener{
                    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        val medidor = Datos.Lectura[position]
                        val pos = position
                        intentEditar.putExtra("casa",medidor)
                        intentEditar.putExtra("pos", pos)
                        startActivity(intentEditar)
                    }
                }
        registerForContextMenu(listaLecturas)
    }
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        menu!!.setHeaderTitle("Opciones")
        menu.add(0,v!!.id,0,"")
        menu.add(0, v.id,1,"Editar")
        menu.add(0, v.id,2,"Eliminar")
        menu.add(0, v.id,3,"Mostrar")
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val selectedItemOrder = item!!.order
        val selecItemTitle = item.title
        val informa = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val lisPosition = informa.position
        val name = listaLecturas.adapter
        when(selectedItemOrder){
            1 -> irEditar(lisPosition)
            2 -> /*Alerter.create(this@ListarActivity)
                .setTitle("eliminar")
                .setText("autor eliminado")
                .setBackgroundColorRes(R.color.colorAccent)
                .show()*/
                borrarLectura(lisPosition)
            3 -> mostrarConenido(lisPosition)
            4 -> Log.i("hola","hola2")
        }
        return true
    }

    fun irEditar(position: Int){
        val intenEdi = Intent(this, EditarLecturaActivity::class.java)
        val medidor = Datos.Lectura[position]
        val pos = position
        intenEdi.putExtra("casa",medidor)
        intenEdi.putExtra("pos", pos)
        this.startActivity(intenEdi)
    }
    fun borrarLectura (pos:Int):Unit{
        Datos.Lectura.remove(Datos.Lectura[pos])

    }

    fun mostrarConenido(position: Int){
        val builder = AlertDialog.Builder(this)
        val intenEdi = Intent(this, EditarLecturaActivity::class.java)

        val medidor = Datos.Lectura[position]

        val pos = position
        intenEdi.putExtra("casa",medidor)
        intenEdi.putExtra("pos", pos)
        builder.setTitle("Lectura")
        builder.setMessage("Propietario: ${medidor.nombre} \nNumero Medidor: ${medidor.medidor}\nNumero de casa: ${medidor.numCasa} \nLectura:${medidor.lecturaMedidor}\nSector: ${medidor.sector}")
        builder.setPositiveButton("yes",{ dialogInterface: DialogInterface, i: Int ->

        })
        builder.show()
    }



}
