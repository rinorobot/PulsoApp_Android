package com.rinosystems.pulsoapp.Temas

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.rinosystems.pulsoapp.R

class Equidad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equidad)

        val btn_igualdad = findViewById<Button>(R.id.btn_igualdad)
        val btn_cuestionario = findViewById<Button>(R.id.btn_cuestionario)
        val btn_violentometro = findViewById<Button>(R.id.btn_violentometro)

        btn_igualdad.setOnClickListener {
            val url = Intent(Intent.ACTION_VIEW)
            url.data = Uri.parse("https://cieg.unam.mx/igualdad-genero.php")
            startActivity(url)
        }

        btn_cuestionario.setOnClickListener {
            startActivity(Intent(this,Cuestionario::class.java))

        }
        btn_violentometro.setOnClickListener {
            startActivity(Intent(this,Violentometro::class.java))
        }
    }
}