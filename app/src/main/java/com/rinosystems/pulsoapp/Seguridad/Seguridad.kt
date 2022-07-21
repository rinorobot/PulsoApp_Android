package com.rinosystems.pulsoapp.Seguridad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rinosystems.pulsoapp.R
import com.rinosystems.pulsoapp.Tramites.Credenciales
import com.rinosystems.pulsoapp.databinding.ActivitySeguridadBinding

class Seguridad : AppCompatActivity() {
    lateinit var binding: ActivitySeguridadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeguridadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnRecomendaciones.setOnClickListener {
                startActivity(Intent(this@Seguridad, Recomendaciones::class.java))
            }
            btnSenderos.setOnClickListener {
                startActivity(Intent(this@Seguridad, Sendero::class.java))
            }
            btnTelefonos.setOnClickListener {
                startActivity(Intent(this@Seguridad, Telefonos::class.java))
            }
            btnTransportes.setOnClickListener {
                startActivity(Intent(this@Seguridad, Transporte::class.java))
            }
            btnProtocolos.setOnClickListener {
                startActivity(Intent(this@Seguridad, Prococolos::class.java))
            }

        }
    }
}