package com.example.josetabo.examen

import android.os.Parcel
import android.os.Parcelable

class Libros (public val icbn: String, public val nombre: String, public val numeroPaginas: String, public val edicion: String, public val fechaPublicacion: String,
              public val nombreEditorial: String, public val autorId: String): Parcelable {
    constructor(parcel: Parcel): this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ){

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(icbn as Double)
        parcel.writeString(nombre)
        parcel.writeDouble(numeroPaginas as Double)
        parcel.writeDouble(edicion as Double)
        parcel.writeString(fechaPublicacion)
        parcel.writeString(nombreEditorial)
        parcel.writeString(autorId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Libros> {
        override fun createFromParcel(parcel: Parcel): Libros {
            return Libros(parcel)
        }

        override fun newArray(size: Int): Array<Libros?> {
            return arrayOfNulls(size)
        }
    }
    override fun toString(): String {
        return "Libros: ${nombre}"
    }
}