package com.example.simplecontactos.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.simplecontactos.R
import com.example.simplecontactos.adapter.ContactoAdapter.*
import com.example.simplecontactos.databinding.ItemRowBinding
import com.example.simplecontactos.model.Contacto
import com.example.simplecontactos.utils.dialPhoneNumber

class ContactoAdapter(var context: Context) : RecyclerView.Adapter<MyViewHolder>() {
    private var lista: ArrayList<Contacto> = ArrayList()


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRowBinding.bind(itemView)
        val tvTelRow = binding.tvTelRow
        val imageButton = binding.imageButton
        fun unirDatos(contacto: Contacto) {
            with(binding) {
                tvNombreRow.text = contacto.nombre
                tvTelRow.text = contacto.numero


            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = lista[position]
        holder.unirDatos(lista[position])

        holder.imageButton.setOnClickListener {
           dialPhoneNumber(currentItem.numero, context)
        }

    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun setContacto(lista: ArrayList<Contacto>) {
        this.lista = lista
        notifyDataSetChanged()
    }
}