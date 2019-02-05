package com.example.josetabo.examen

import android.os.Parcel
import android.os.Parcelable

class Autores (public var nombre: String, var apellido: String, var fechaNacimiento: String, var numLibros: String, var ecuatoriano: String): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ){

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(apellido)
        parcel.writeString(fechaNacimiento)
        parcel.writeString(numLibros)
        parcel.writeString(ecuatoriano)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Autores> {
        override fun createFromParcel(parcel: Parcel): Autores {
            return Autores(parcel)
        }

        override fun newArray(size: Int): Array<Autores?> {
            return arrayOfNulls(size)
        }
    }
    override fun toString(): String {
        return "Autor#${nombre}"
    }
}