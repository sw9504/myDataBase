package com.utn.mydatabase.database

import androidx.room.Dao
import androidx.room.Query

@Dao
public interface userDao {
    @Query("SELECT * FROM users ORDER BY id")
    fun loadAllCharacters() : MutableList<Character>

    @Query("INSERT INTO users (name, imgAvatar) VALUES (:name, :imgAvatar)")
    fun addCharacter(name : String, imgAvatar : String)
}