package com.example.josetabo.proyecto

import android.os.Parcel
import android.os.Parcelable

class Lectura (val sector: String, val medidor: String, val nombre: String, val numCasa: String, val lecturaMedidor: String): Parcelable {
    constructor(parcel: Parcel): this (
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ){

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(sector)
        parcel.writeString(medidor)
        parcel.writeString(nombre)
        parcel.writeString(numCasa)
        parcel.writeString(lecturaMedidor)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Lectura> {
        override fun createFromParcel(parcel: Parcel): Lectura {
            return Lectura(parcel)
        }

        override fun newArray(size: Int): Array<Lectura?> {
            return arrayOfNulls(size)
        }
    }
    override fun toString(): String {
        return "Lectura medidor#:${medidor}, Dueño: ${nombre}"
    }

}