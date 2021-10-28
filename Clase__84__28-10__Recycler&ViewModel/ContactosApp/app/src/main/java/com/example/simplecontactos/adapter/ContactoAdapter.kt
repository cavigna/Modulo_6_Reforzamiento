package com.example.simplecontactos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplecontactos.R
import com.example.simplecontactos.adapter.ContactoAdapter.*
import com.example.simplecontactos.databinding.ItemRowBinding
import com.example.simplecontactos.model.Contacto

class ContactoAdapter(): RecyclerView.Adapter<MyViewHolder>() {
    private var lista: ArrayList<Contacto> = ArrayList()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = ItemRowBinding.bind(itemView)

        fun unirDatos(contacto: Contacto){
            with(binding){
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
        holder.unirDatos(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun setContacto(lista:ArrayList<Contacto>){
        this.lista = lista
        notifyDataSetChanged()
    }
}