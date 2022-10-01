package com.utn.mydatabase.entities

import androidx.room.*

@Entity(tableName = "users")
class Character(id : Int, name : String, imgAvatar : String) {
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id : Int

    @ColumnInfo(name = "name")
    var name : String

    @ColumnInfo(name = "imgAvatar")
    var imgAvatar : String

    init {
        this.id = id
        this.name = name
        this.imgAvatar = imgAvatar
    }
}
