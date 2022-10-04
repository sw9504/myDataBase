package com.utn.mydatabase.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.utn.mydatabase.R
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.utn.mydatabase.database.appDatabase
import com.utn.mydatabase.database.userDao
import com.utn.mydatabase.entities.Character

class ExpandedFragment : Fragment() {
    lateinit var v : View

    lateinit var characterName : TextView
    lateinit var btnEdit : Button
    lateinit var btnDelete : Button
    lateinit var img : ImageView

    private var db: appDatabase? = null
    private var userDao: userDao? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_expanded, container, false)

        val view = requireActivity().findViewById<BottomNavigationView>(R.id.bottomBar)
        view.visibility = View.GONE

        characterName = v.findViewById(R.id.characterName)
        btnEdit = v.findViewById(R.id.btnEdit)
        btnDelete = v.findViewById(R.id.btnDelete)
        img = v.findViewById(R.id.characterImg)

        return v
    }

    override fun onStart() {
        super.onStart()
        var characterId = ExpandedFragmentArgs.fromBundle(requireArguments()).characterId

        db = appDatabase.getAppDataBase(v.context)
        userDao = db?.userDao()

        var character = userDao?.getCharacter(characterId) as Character

        characterName.text = character.name

        Glide.with(requireContext())
            .load(character.imgAvatar)
            .into(img)
    }
}