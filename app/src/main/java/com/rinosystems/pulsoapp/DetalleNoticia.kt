package com.rinosystems.pulsoapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.rinosystems.pulsoapp.databinding.ActivityDetalleNoticiaBinding
import com.rinosystems.pulsoapp.models.NoticiasData
import com.squareup.picasso.Picasso

class DetalleNoticia : AppCompatActivity() {

    lateinit var binding: ActivityDetalleNoticiaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleNoticiaBinding.inflate(layoutInflater)

        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.pulsoappcolor)
        window.navigationBarColor =  ContextCompat.getColor(this,R.color.pulsoappcolor)


        val noticia = intent.getParcelableExtra<NoticiasData>("noticia")

        if (noticia != null){
            binding.detalleNoticiaTitulo.text = noticia.titulo
            binding.detalleNoticiaFecha.text = noticia.fecha
            binding.detalleNoticiaDescripcion.text = noticia.descripcion
            Picasso.get().load(noticia.imagen).into(binding.detalleNoticiaImagen)
            binding.detalleNoticiaBtn.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(noticia.url))
                startActivity(intent)
            }




        }

    }
}