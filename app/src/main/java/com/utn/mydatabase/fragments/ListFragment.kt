package com.utn.mydatabase.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.utn.mydatabase.R
import com.utn.mydatabase.adapter.CharacterAdapter
import com.utn.mydatabase.database.appDatabase
import com.utn.mydatabase.database.userDao
import com.utn.mydatabase.entities.Character

class ListFragment : Fragment() {
    lateinit var v : View
    lateinit var recCharacter: RecyclerView
    lateinit var adapter: CharacterAdapter
    lateinit var btnAdd : Button

    private var db: appDatabase? = null
    private var userDao: userDao? = null

    var characterList : MutableList<Character> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v =  inflater.inflate(R.layout.fragment_list, container, false)

        // Si no pongo esto me desaparece la bottom bar al volver
        val view = requireActivity().findViewById<BottomNavigationView>(R.id.bottomBar)
        view.visibility = View.VISIBLE

        recCharacter = v.findViewById(R.id.recCharacter)
        btnAdd = v.findViewById(R.id.btnAdd)

        return v
    }

    override fun onStart() {
        super.onStart()
        db = appDatabase.getAppDataBase(v.context)
        userDao = db?.userDao()

        characterList = userDao?.loadAllCharacters() as MutableList<Character>

        adapter = CharacterAdapter(characterList) { position ->
            var action = ListFragmentDirections.actionListFragmentToExpandedFragment(characterList[position].id)
            v.findNavController().navigate(action)
        }
        recCharacter.layoutManager = LinearLayoutManager(requireContext())
        recCharacter.adapter = adapter

        btnAdd.setOnClickListener {
            var action = ListFragmentDirections.actionListFragmentToNewCharacterFragment()
            v.findNavController().navigate(action)
        }
    }
}