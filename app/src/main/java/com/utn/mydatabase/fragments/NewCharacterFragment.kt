package com.utn.mydatabase.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.utn.mydatabase.R
import com.utn.mydatabase.database.appDatabase
import com.utn.mydatabase.database.userDao

class NewCharacterFragment : Fragment() {
    lateinit var v : View
    lateinit var inputName : EditText
    lateinit var inputUrl : EditText
    lateinit var btnAdd : Button

    private var db: appDatabase? = null
    private var userDao: userDao? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v =  inflater.inflate(R.layout.fragment_new_character, container, false)

        val view = requireActivity().findViewById<BottomNavigationView>(R.id.bottomBar)
        view.visibility = View.GONE

        inputName = v.findViewById(R.id.inputName)
        inputUrl = v.findViewById(R.id.inputUrl)
        btnAdd = v.findViewById(R.id.btnDBAdd)

        return v
    }

    override fun onStart() {
        super.onStart()
        db = appDatabase.getAppDataBase(v.context)
        userDao = db?.userDao()

        btnAdd.setOnClickListener {
            val name = inputName.text
            val url = inputUrl.text

            userDao?.addCharacter(name.toString(),url.toString())
            v.findNavController().navigateUp()
        }

    }
}