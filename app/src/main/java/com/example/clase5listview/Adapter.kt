package com.example.clase5listview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class Adapter() : ListAdapter<Comida, Adapter.ViewHolder>(DiffCallBack) {
    inner class  ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val name : TextView = view.findViewById(R.id.textViewName)
        private val nivel_de_sabrosura : TextView = view.findViewById(R.id.textViewNivelDeSabrosura)
        private val origen : TextView = view.findViewById(R.id.textViewOrigen)
        private val ingredientes : TextView = view.findViewById(R.id.textViewIngredientes)

        fun bind (comida: Comida) {
            name.text = comida.name.toString()
            nivel_de_sabrosura.text = comida.nivel_de_sabrosura.toString()
            origen.text = comida.origen
            ingredientes.text = comida.ingredientes

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comida = getItem(position)
        holder.bind(comida)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Comida>(){
        override fun areItemsTheSame(oldItem: Comida, newItem: Comida): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Comida, newItem: Comida): Boolean {
            return  oldItem == newItem
        }
    }
}