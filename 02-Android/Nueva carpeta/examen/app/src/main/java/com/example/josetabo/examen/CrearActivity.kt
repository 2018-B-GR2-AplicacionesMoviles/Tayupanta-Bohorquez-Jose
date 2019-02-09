package com.example.josetabo.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.activity_crear.*


class CrearActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear)

        btn_cancelar.setOnClickListener{
            cancelar()
        }
        btn_guardar.setOnClickListener{
            aceptar()
            this.finish()
        }
    }

    fun cancelar(){

        val intent = Intent( this, MainActivity::class.java)
        this.startActivity(intent)
        this.finish()
    }

    fun aceptar(){
        val url = "http://172.29.64.211:1337/autores"
        val autor = Autores(
             nombre = editNombre.text.toString(),
            apellido = editApellido.text.toString(),
            fechaNacimiento = editFechaNa.text.toString(),
            numLibros = editNumeroLibros.text.toString(),
            ecuatoriano = editEcuatoriano.text.toString()
        )
        val parametro = listOf("nombre" to autor.nombre,
                            "apellido" to autor.apellido,
                            "fechaNacimiento" to autor.fechaNacimiento,
                            "numLibros" to autor.numLibros,
                            "ecuatoriano" to autor.ecuatoriano)
        url.httpPost(parametro).responseString{request, response, result ->
            when(result){
                is  Result.Failure -> {
                    val exception = result.getException()
                    Toast.makeText(this, "Error:${exception}", Toast.LENGTH_SHORT).show()
                }
                is Result.Success -> {
                    Alerter.create(this@CrearActivity)
                        .setTitle("resgistro")
                        .setText("autor guardado con exito")
                        .setBackgroundColorRes(R.color.colorPrimary)
                        .show()
                }
            }
        }
        editNombre.setText("")
        editApellido.setText("")
        editFechaNa.setText("")
        editNumeroLibros.setText("")
        editEcuatoriano.setText("")
    }
}
