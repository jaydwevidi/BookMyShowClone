package com.example.bookmyshowclone

data class MyCityObject(
    var id: Int,
    var name: String,
    var pictureURL: String
) {
    override fun toString(): String {
        return "[ $id , $name , $pictureURL ]"
    }
}

