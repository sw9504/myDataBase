package com.utn.mydatabase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.utn.mydatabase.R
import com.utn.mydatabase.entities.Character

class CharacterAdapter(private var characterList : MutableList <Character>) : RecyclerView.Adapter<CharacterAdapter.CharacterHolder> (){

    class CharacterHolder (v: View) : RecyclerView.ViewHolder(v) {
        private var view: View
        init {
            this.view = v
        }

        fun setName (name : String) {
            var txtName : TextView = view.findViewById(R.id.txtName)
            txtName.text = name
        }

        fun setImg (img : String) {
            var imgCircle: ImageView = view.findViewById((R.id.imgCircle))
            var imgUrl = img

            Glide.with(view)
                .load(imgUrl)
                .circleCrop()
                .into(imgCircle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_character,parent,false)
        return (CharacterHolder(view))
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.setName(characterList[position].name)
        holder.setImg(characterList[position].imgAvatar)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }
}
