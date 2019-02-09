package com.example.josetabo.examen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.activity_crear.*
import kotlinx.android.synthetic.main.activity_crear_libros.*

class CrearLibrosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_libros)

        btn_guardar.setOnClickListener{
            aceptar()
            this.finish()
        }
        cancelar.setOnClickListener{
            this.finish()
        }
    }

    fun aceptar(){
        val url = "http://172.29.64.211:1337/libros"
        val libro = Libros(
            icbn= editIcnb.text.toString(),
            nombre= editNombreLibro.text.toString(),
            numeroPaginas= editNumPag.text.toString(),
            edicion= editEdicion.text.toString(),
            fechaPublicacion= editFechaPub.text.toString(),
            nombreEditorial= editNombEdit.text.toString(),
            autorId= editAutorId.text.toString()
        )
        val parametro = listOf("icbn" to libro.icbn,
            "nombre" to libro.nombre,
            "numeroPaginas" to libro.numeroPaginas,
            "edicion" to libro.edicion,
            "fechaPublicacion" to libro.fechaPublicacion,
            "nombreEditorial" to libro.nombreEditorial,
            "autorId" to libro.autorId)
        url.httpPost(parametro).responseString{request, response, result ->
            when(result){
                is  Result.Failure -> {
                    val exception = result.getException()
                    Toast.makeText(this, "Error:${exception}", Toast.LENGTH_SHORT).show()
                }
                is Result.Success -> {
                    Alerter.create(this@CrearLibrosActivity)
                        .setTitle("resgistro")
                        .setText("autor guardado con exito")
                        .setBackgroundColorRes(R.color.colorPrimary)
                        .show()
                }
            }
        }
        editIcnb.setText("")
        editNombreLibro.setText("")
        editNumPag.setText("")
        editEdicion.setText("")
        editFechaPub.setText("")
        editNombEdit.setText("")
        editAutorId.setText("")
    }
}
