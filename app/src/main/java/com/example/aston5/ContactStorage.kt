package com.example.aston5

import android.os.Parcel
import android.os.Parcelable


data class ContactStorage(
    val firstName: String?,
    val lastName: String?,
    val phoneNumber: String?,
    val id: Int
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(phoneNumber)
        parcel.writeInt(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ContactStorage> {
        override fun createFromParcel(parcel: Parcel): ContactStorage {
            return ContactStorage(parcel)
        }

        override fun newArray(size: Int): Array<ContactStorage?> {
            return arrayOfNulls(size)
        }
    }
}

