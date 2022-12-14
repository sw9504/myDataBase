package com.utn.mydatabase.database

import androidx.room.*
import com.utn.mydatabase.entities.Character

@Dao
public interface userDao {

    @Query("SELECT * FROM users ORDER BY id")
    fun loadAllCharacters(): MutableList<Character?>?

    @Query("INSERT INTO users (name, imgAvatar) VALUES (:name, :imgAvatar)")
    fun addCharacter(name : String, imgAvatar : String)

    @Query("SELECT * FROM users WHERE id = :id")
    fun getCharacter(id : Int) : Character?

    @Query("DELETE FROM users WHERE id = :id")
    fun deleteCharacter(id : Int)

    @Query("UPDATE users SET name = :name, imgAvatar = :imgAvatar WHERE id = :id")
    fun updateCharacter(id : Int, name : String, imgAvatar : String)
}