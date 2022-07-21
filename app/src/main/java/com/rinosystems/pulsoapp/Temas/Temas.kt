package com.rinosystems.pulsoapp.Temas

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rinosystems.pulsoapp.R
import com.rinosystems.pulsoapp.databinding.ActivityTemasBinding

class Temas : AppCompatActivity() {
    lateinit var bindind: ActivityTemasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindind = ActivityTemasBinding.inflate(layoutInflater)
        setContentView(bindind.root)

        bindind.apply {

            btnIdentidad.setOnClickListener {
                startActivity(Intent(this@Temas,Identidad::class.java))
            }
            btnPsi.setOnClickListener {
               val url = Intent(Intent.ACTION_VIEW)
                url.data = Uri.parse("https://psi.cch.unam.mx/")
                startActivity(url)
            }
            btnEquidad.setOnClickListener {
                startActivity(Intent(this@Temas,Equidad::class.java))
            }
            btnEstrategias.setOnClickListener {
                val url = Intent(Intent.ACTION_VIEW)
                url.data = Uri.parse("https://www.cch.unam.mx/estudiante/habitos-de-estudio")
                startActivity(url)
            }

        }



    }
}