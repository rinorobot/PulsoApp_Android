package com.rinosystems.pulsoapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rinosystems.pulsoapp.R
import com.squareup.picasso.Picasso

class PublicacionItemAdapter(private val context: Context, private val titulos: List<String>, private val lista_portadas: List<String>,private  val lista_url: List<String>, val itemClickListener: PublicacionItemViewHolder.OnNoticiasClickListener): RecyclerView.Adapter<PublicacionItemAdapter.PublicacionItemViewHolder>() {



    class PublicacionItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val portada: ImageView = itemView.findViewById(R.id.imagen_publicacion_item)
        val titulo: TextView = itemView.findViewById(R.id.titulo_publicacion_item)
        val ver_publi: LinearLayout = itemView.findViewById(R.id.ver_publicacion)

        interface OnNoticiasClickListener{

            fun onItemClick(url: String)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublicacionItemViewHolder {
        return PublicacionItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_publicaciones,parent,false))
    }

    override fun onBindViewHolder(holder: PublicacionItemViewHolder, position: Int) {
        Picasso.get().load(lista_portadas[position]).into(holder.portada)
        holder.titulo.text = titulos[position]
        holder.ver_publi.setOnClickListener {
            itemClickListener.onItemClick(lista_url[position])
        }
    }

    override fun getItemCount(): Int {
        return titulos.size
    }
}