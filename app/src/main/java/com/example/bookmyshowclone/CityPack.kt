package com.example.bookmyshowclone

data class CityPack(
    val c1 :MyCityObject,
    val c2 :MyCityObject,
    val c3 :MyCityObject

) {
    override fun toString(): String {
        return "[$c1 , $c2 , $c3]"
    }
}