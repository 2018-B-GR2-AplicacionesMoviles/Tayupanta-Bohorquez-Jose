package com.example.josetabo.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.activity_listar.*

class ListarActivity : AppCompatActivity() {
    lateinit var array: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)

        array = arrayOf("Gabriel Garcia", "Pablo Neruda", "William Shakespeare")
        insertar()
        val base = ArrayAdapter(this@ListarActivity, android.R.layout.simple_list_item_1, array)
        listar.adapter = base
        //listar.adapter = ArrayAdapter<Autores>(
         //   this, android.R.layout.simple_expandable_list_item_1, Datos.Autores)

        val intentEditar = Intent(this, CrearActivity::class.java)
        listar
            .onItemClickListener =
                object : AdapterView.OnItemClickListener{
                    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        val medidor = Datos.Autores[position]
                        val pos = position
                        intentEditar.putExtra("casa",medidor)
                        intentEditar.putExtra("pos", pos)
                        startActivity(intentEditar)
                    }
                }
        registerForContextMenu(listar)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu!!.setHeaderTitle("Opciones")
        menu.add(0,v!!.id,0,"Eliminar")
        menu.add(0, v.id,1,"Editar")
        menu.add(0, v.id,2,"Listar Libros")
        menu.add(0, v.id,3,"Compartir")
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val selectedItemOrder = item!!.order
        val selecItemTitle = item.title
        val informa = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val lisPosition = informa.position
        val name = array[lisPosition]
        when(selectedItemOrder){
            0 -> borrarLectura(lisPosition)
            1 -> irEditar()
            2 -> /*Alerter.create(this@ListarActivity)
                .setTitle("eliminar")
                .setText("autor eliminado")
                .setBackgroundColorRes(R.color.colorAccent)
                .show()*/
                irListarLibros()
            3 -> Log.i("hola","hola2")
            4 -> {
                val intent2 = Intent(Intent.ACTION_SEND)
                intent2.setType("imagen/**")
                startActivity(Intent.createChooser(intent2,"compartir"))
            }
        }
        return true
    }

    fun insertar() {
        val url = "http://172.29.64.211:1337/autores"
        url.httpGet().responseString{request, response, result ->
            when(result){
                is Result.Failure -> {
                    val exception = result.getException()
                }
                is Result.Success -> {
                    val response = result.get()
                    Toast.makeText(this, "${response}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun irListarLibros(){
        val intent = Intent(this, ListarLibrosActivity::class.java)
        startActivity(intent)
    }

    fun irEditar(){
        val intentEditar = Intent(this, CrearActivity::class.java)
        startActivity(intentEditar)
        this.finish()
    }

    fun borrarLectura (pos:Int):Unit{
        Datos.Autores.remove(Datos.Autores[pos])

    }
}
