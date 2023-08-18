package com.rinosystems.pulsoapp.models

import android.os.Parcel
import android.os.Parcelable

data class NewsDataItem(
    val descripcion: String? = null,
    val fecha: String? = null,
    val imagen: String? = null,
    val titulo: String? = null,
    val url: String? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(descripcion)
        parcel.writeString(fecha)
        parcel.writeString(imagen)
        parcel.writeString(titulo)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NewsDataItem> {
        override fun createFromParcel(parcel: Parcel): NewsDataItem {
            return NewsDataItem(parcel)
        }

        override fun newArray(size: Int): Array<NewsDataItem?> {
            return arrayOfNulls(size)
        }
    }


}
