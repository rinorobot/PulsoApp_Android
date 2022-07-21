package com.rinosystems.pulsoapp.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rinosystems.pulsoapp.R
import com.rinosystems.pulsoapp.models.TitulosPublicaciones

class TitulosPublicacionesAdapter(private val context: Context, private val titulosPublicaciones: List<TitulosPublicaciones>): RecyclerView.Adapter<TitulosPublicacionesAdapter.ViewHolderPublicaciones>(),PublicacionItemAdapter.PublicacionItemViewHolder.OnNoticiasClickListener  {


class ViewHolderPublicaciones(itemView: View): RecyclerView.ViewHolder(itemView){
   val tituloPublicacion: TextView = itemView.findViewById(R.id.titulo_publicacion)
    val publicacion_item_rv: RecyclerView = itemView.findViewById(R.id.publicaciones_recycler_view)
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPublicaciones {
    return ViewHolderPublicaciones(LayoutInflater.from(context).inflate(R.layout.titulos_publicaciones,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolderPublicaciones, position: Int) {
        val publicaciones = titulosPublicaciones[position]

        holder.tituloPublicacion.text = publicaciones.publicacion
        cargarItemPublicaciones(holder.publicacion_item_rv,publicaciones.titulo!!,publicaciones.portada!!,publicaciones.url!!)

    }

    override fun getItemCount(): Int {
        return titulosPublicaciones.size
    }

    private fun cargarItemPublicaciones(recyclerView: RecyclerView, titulos: List<String>, portadas: List<String>,urls: List<String>){

        val itemRecyclerAdapter = PublicacionItemAdapter(context,titulos,portadas,urls,this)
        recyclerView.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        recyclerView.adapter = itemRecyclerAdapter
    }

    override fun onItemClick(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(context,intent,null)
    }


}