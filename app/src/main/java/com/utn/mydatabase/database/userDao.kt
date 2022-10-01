package com.utn.mydatabase.database

import androidx.room.*
import com.utn.mydatabase.entities.Character

@Dao
public interface userDao {

    @Query("SELECT * FROM users ORDER BY id")
    fun loadAllCharacters(): MutableList<Character?>?

    @Query("INSERT INTO users (name, imgAvatar) VALUES (:name, :imgAvatar)")
    fun addCharacter(name : String, imgAvatar : String)
}