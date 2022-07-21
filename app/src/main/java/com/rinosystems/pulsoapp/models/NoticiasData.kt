package com.rinosystems.pulsoapp.models

import android.os.Parcel
import android.os.Parcelable

data class NoticiasData(var titulo: String? = null, var fecha: String? =  null, var descripcion: String? = null, var imagen: String? = null, var url: String? = null): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(titulo)
        parcel.writeString(fecha)
        parcel.writeString(descripcion)
        parcel.writeString(imagen)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NoticiasData> {
        override fun createFromParcel(parcel: Parcel): NoticiasData {
            return NoticiasData(parcel)
        }

        override fun newArray(size: Int): Array<NoticiasData?> {
            return arrayOfNulls(size)
        }
    }
}
