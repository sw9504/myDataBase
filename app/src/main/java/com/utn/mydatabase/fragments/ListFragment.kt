package com.utn.mydatabase.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.utn.mydatabase.R
import com.utn.mydatabase.adapter.CharacterAdapter
import com.utn.mydatabase.entities.Character

class ListFragment : Fragment() {
    lateinit var v : View
    lateinit var recCharacter: RecyclerView

    var characterList : MutableList<Character> = mutableListOf()
    lateinit var  adapter: CharacterAdapter

    lateinit var btnAdd : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v =  inflater.inflate(R.layout.fragment_list, container, false)

        recCharacter = v.findViewById(R.id.recCharacter)
        btnAdd = v.findViewById(R.id.btnAdd)

        characterList.add(Character(0,"Daemon Targaryen","https://elcomercio.pe/resizer/z02V2gqW5PXwtH4ZhOXazaNx4X0=/580x330/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/P25L6EQZ35AKZO32DIQQ3JNSJM.jpg"))
        characterList.add(Character(0,"Daemon Targaryen","https://elcomercio.pe/resizer/z02V2gqW5PXwtH4ZhOXazaNx4X0=/580x330/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/P25L6EQZ35AKZO32DIQQ3JNSJM.jpg"))
        characterList.add(Character(0,"Daemon Targaryen","https://elcomercio.pe/resizer/z02V2gqW5PXwtH4ZhOXazaNx4X0=/580x330/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/P25L6EQZ35AKZO32DIQQ3JNSJM.jpg"))
        characterList.add(Character(0,"Daemon Targaryen","https://elcomercio.pe/resizer/z02V2gqW5PXwtH4ZhOXazaNx4X0=/580x330/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/P25L6EQZ35AKZO32DIQQ3JNSJM.jpg"))
        characterList.add(Character(0,"Daemon Targaryen","https://elcomercio.pe/resizer/z02V2gqW5PXwtH4ZhOXazaNx4X0=/580x330/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/P25L6EQZ35AKZO32DIQQ3JNSJM.jpg"))

        return v
    }

    override fun onStart() {
        super.onStart()
        adapter = CharacterAdapter(characterList)
        recCharacter.layoutManager = LinearLayoutManager(requireContext())
        recCharacter.adapter = adapter

        btnAdd.setOnClickListener {

        }
       }
}