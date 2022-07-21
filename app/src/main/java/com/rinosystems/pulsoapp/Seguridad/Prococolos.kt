package com.rinosystems.pulsoapp.Seguridad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rinosystems.pulsoapp.R
import com.rinosystems.pulsoapp.databinding.ActivityPrococolosBinding

class Prococolos : AppCompatActivity() {
    lateinit var binding: ActivityPrococolosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrococolosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnArma.setOnClickListener {
                startActivity(Intent(this@Prococolos,Arma::class.java))
            }
            btnSituacion.setOnClickListener {
                startActivity(Intent(this@Prococolos,Exterior::class.java))
            }
            btnFaltas.setOnClickListener {
                startActivity(Intent(this@Prococolos,Faltas::class.java))
            }
            btnSismo.setOnClickListener {
                startActivity(Intent(this@Prococolos,SIsmo::class.java))
            }
            btnIncendio.setOnClickListener {
                startActivity(Intent(this@Prococolos,Incendio::class.java))
            }

            btnFuga.setOnClickListener {
                startActivity(Intent(this@Prococolos,Fuga::class.java))
            }
            btnUrgencia.setOnClickListener {
                startActivity(Intent(this@Prococolos,Urgencia::class.java))
            }
            btnViolencia.setOnClickListener {
                startActivity(Intent(this@Prococolos,Genero::class.java))
            }
            btnSustancias.setOnClickListener {
                startActivity(Intent(this@Prococolos,Sustancias::class.java))
            }
            btnViolenciaInterior.setOnClickListener {
                startActivity(Intent(this@Prococolos,Interior::class.java))
            }
            btnDenuncia.setOnClickListener {
                startActivity(Intent(this@Prococolos,Denuncia::class.java))
            }


        }
    }
}