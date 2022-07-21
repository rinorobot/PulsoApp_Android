package com.rinosystems.pulsoapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rinosystems.pulsoapp.R
import com.rinosystems.pulsoapp.models.NoticiasData
import com.squareup.picasso.Picasso
import java.util.ArrayList

class NoticiasAdapter(private val noticiasList: ArrayList<NoticiasData>, val itemClickListener: MyViewHolder.OnNoticiasClickListener): RecyclerView.Adapter<NoticiasAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_noticias,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val noticia = noticiasList[position]

        holder.titulo.text = noticia.titulo
        holder.fecha.text = noticia.fecha
        holder.descripcion.text = noticia.descripcion
        Picasso.get().load(noticia.imagen).placeholder(R.drawable.logo_color_nau).into(holder.imagen)
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(noticia)
        }




    }

    override fun getItemCount(): Int {
        return noticiasList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val titulo: TextView = itemView.findViewById(R.id.item_titulo)
        val fecha: TextView = itemView.findViewById(R.id.item_fecha)
        val descripcion: TextView = itemView.findViewById(R.id.item_descripcion)
        val imagen: ImageView = itemView.findViewById(R.id.item_imagen)

        interface OnNoticiasClickListener{

            fun onItemClick(noticia: NoticiasData)

        }


    }

}