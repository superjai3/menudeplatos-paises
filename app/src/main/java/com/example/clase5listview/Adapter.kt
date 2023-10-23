package com.example.clase5listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val context: Context) : ListAdapter<Comida, Adapter.ViewHolder>(DiffCallBack) {
    inner class  ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val name : TextView = view.findViewById(R.id.textViewName)
        private val nivel_de_sabrosura : TextView = view.findViewById(R.id.textViewNivelDeSabrosura)
        private val origen : TextView = view.findViewById(R.id.textViewOrigen)
        private val ingredientes : TextView = view.findViewById(R.id.textViewIngredientes)
        private val imagenBandera: ImageView = view.findViewById(R.id.imageViewBandera)
        private val image: ImageView = view.findViewById(R.id.imageViewImage)

        fun bind (comida: Comida) {
            name.text = "Menú: " + comida.name.toString()
            nivel_de_sabrosura.text = "Nivel de Sabrosura: " + comida.nivel_de_sabrosura.toInt()
            origen.text = "Origen: " + comida.origen.toString()
            ingredientes.text = "Ingredientes: " + comida.ingredientes.toString()

            val imagen = when (comida.origen){
                Bandera.ARGENTINA -> R.drawable.argentina
                Bandera.CHILE -> R.drawable.chile
                Bandera.PERU -> R.drawable.peru
                else -> {
                    Bandera.VENEZUELA ; R.drawable.venezuela
                }
            }
            imagenBandera.setImageResource(imagen)
            Glide.with(context).load(comida.image).into(image);


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