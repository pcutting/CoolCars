package com.nevie.coolcars.Model

import android.os.Parcel
import android.os.Parcelable


data class Car (
    var make : String = "",
    var model: String = "",
    var year: Int = 0,
    var image: String = "",
    var thumbnail: String = "",
    var rangeHighway: Double = 0.0,
    var rangeCity: Double = 0.0,
    var hp: Int = 0,
    var zeroToSixty: Double = 0.0
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt() ?: 0,
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readDouble() ?: 0.0,
        parcel.readDouble() ?: 0.0,
        parcel.readInt() ?: 0,
        parcel.readDouble() ?: 0.0
    ) {
    }


    override fun describeContents(): Int {
        return 0

    }
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(make)
        dest.writeString(model)
        dest.writeInt(year)
        dest.writeString(image)
        dest.writeString(thumbnail)
        dest.writeDouble(rangeHighway)
        dest.writeDouble(rangeCity)
        dest.writeInt(hp)
        dest.writeDouble(zeroToSixty)
    }

    fun getExample1(): Car {
        return Car(
            make = "Ford",
            model = "Mustang GT",
            year = 1966,
            image = "mustang_big.jpg",
            thumbnail = "mustang_1.jpg",
            rangeHighway = 16.9,
            rangeCity = 13.9,
            hp = 271,
            zeroToSixty = 6.2
        )
    }

    fun getExample2(): Car {
        return Car(
            make = "Jaguar",
            model = "E Type",
            year = 1967,
            image = "jagwar_big.jpg",
            thumbnail = "jagwar_1.jpg",
            rangeHighway = 14.0,
            rangeCity = 11.7,
            hp = 246,
            zeroToSixty = 7.0
        )
    }

    companion object CREATOR : Parcelable.Creator<Car> {
        override fun createFromParcel(parcel: Parcel): Car {
            return Car(parcel)
        }

        override fun newArray(size: Int): Array<Car?> {
            return arrayOfNulls(size)
        }
    }


}