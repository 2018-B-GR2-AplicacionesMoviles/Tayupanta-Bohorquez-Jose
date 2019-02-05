package com.example.josetabo.examen

import android.os.StrictMode
import android.util.Log
import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import java.lang.StringBuilder

class BaseDatosAutores {
    companion object {
        fun insertarAutor(autor: Autores) {
            "http://localhost:1337/Autores".httpPost(
                listOf(
                    "nombre" to autor.nombre,
                    "apellido" to autor.apellido,
                    "fechaNacimiento" to autor.fechaNacimiento,
                    "numLibros" to autor.numLibros,
                    "ecuatoriano" to autor.ecuatoriano
                )
            ).responseString { request, _, result -> Log.d("http-ejemplo", request.toString())
            }
        }
        fun getList(): ArrayList<Autores> {
            val autores: ArrayList<Autores> = ArrayList()
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            val (request, response, result) = "http://172.29.28.40:1337/Autores".httpGet().responseString()
            val jsonStringAutores = result.get()

            val parser = Parser()
            val stringBuilder = StringBuilder(jsonStringAutores)
            val array = parser.parse(stringBuilder) as JsonArray<JsonObject>

            array.forEach {
                val nombre = it["nombre"] as String
                val apellido = it["apellido"] as String
                val fechaNacimiento = it["fechaNacimiento"] as String
                val numLibros = it["numLibros"] as String
                val ecuatoriano = it["ecuatoriano"] as String
                val autor = Autores(nombre, apellido, fechaNacimiento, numLibros, ecuatoriano)
                autores.add(autor)
            }
            return autores
        }
    }
}