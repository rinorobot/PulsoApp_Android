package com.rinosystems.pulsoapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.rinosystems.pulsoapp.R
import com.rinosystems.pulsoapp.models.ExamenesData

import com.squareup.picasso.Picasso
import java.util.ArrayList

class ExamenesAdapter(private var examenesLista: List<ExamenesData>, val itemClickListener: ExamenesViewHolder.OnNoticiasClickListener): RecyclerView.Adapter<ExamenesAdapter.ExamenesViewHolder>() {




class ExamenesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val nombre: TextView = itemView.findViewById(R.id.nombre_examen)
    val area: TextView = itemView.findViewById(R.id.area_examen)
    val descripcion: TextView = itemView.findViewById(R.id.descripcion_examen)
    val imagen: ImageView = itemView.findViewById(R.id.imagen_examen)
    val btnExamen: CardView = itemView.findViewById(R.id.btnExamen)

    interface OnNoticiasClickListener{

        fun onItemClick(examen: String,nombre: String)

    }

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamenesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_examenes,parent,false)
        return ExamenesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExamenesViewHolder, position: Int) {
        val examen = examenesLista[position]

        holder.nombre.text = examen.nombre_examen
        holder.area.text = examen.area
       holder.descripcion.text = examen.mensaje

        holder.btnExamen.setOnClickListener {
            itemClickListener.onItemClick(examen.key!!,examen.nombre_examen!!)
        }

        if(examen.area.equals("Matemáticas")){
            Picasso.get().load(R.drawable.mates).placeholder(R.drawable.logo_color_nau).into(holder.imagen)
        }
        else if(examen.area.equals("Idiomas")){
            Picasso.get().load(R.drawable.idiomas).placeholder(R.drawable.logo_color_nau).into(holder.imagen)
        }
       else if(examen.area.equals("Experimentales")){
            Picasso.get().load(R.drawable.expe).placeholder(R.drawable.logo_color_nau).into(holder.imagen)
        }
        else if(examen.area.equals("Historia")){
            Picasso.get().load(R.drawable.histo).placeholder(R.drawable.logo_color_nau).into(holder.imagen)
        }
        else if(examen.area.equals("Talleres")){
            Picasso.get().load(R.drawable.lite).placeholder(R.drawable.logo_color_nau).into(holder.imagen)
        }



    }

    override fun getItemCount(): Int {
     return   examenesLista.size
    }



}