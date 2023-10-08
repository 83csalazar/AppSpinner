package com.example.appspinner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appspinner.R

class MyAdapter(private val dataList: List<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var selectedCategory: String = "Universo 1" // Categoría predeterminada

    fun setSelectedCategory(category: String) {
        selectedCategory = category
        notifyDataSetChanged() // Notificar al adaptador que los datos han cambiado
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = dataList[position]

        // Aquí establece la imagen y el título del elemento en la tarjeta basándote en la categoría seleccionada
        when (selectedCategory) {
            "Universo 1" -> {
                holder.imageView.setImageResource(R.drawable.img1)
                holder.textViewTitle.text = "Imagen 1"
            }
            "Universo 2" -> {
                holder.imageView.setImageResource(R.drawable.img2)
                holder.textViewTitle.text = "Imagen 2"
            }
            "Universo 3" -> {
                holder.imageView.setImageResource(R.drawable.img3)
                holder.textViewTitle.text = "Imagen 3"
            }
            else -> {
                holder.imageView.setImageResource(R.drawable.img1)
                holder.textViewTitle.text = "Imagen por defecto"
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)
    }
}
