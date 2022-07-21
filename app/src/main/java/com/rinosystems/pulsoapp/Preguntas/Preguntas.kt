package com.rinosystems.pulsoapp.Preguntas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rinosystems.pulsoapp.R
import com.rinosystems.pulsoapp.Tramites.*
import com.rinosystems.pulsoapp.databinding.ActivityPreguntasBinding

class Preguntas : AppCompatActivity() {
    lateinit var binding: ActivityPreguntasBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityPreguntasBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.apply {
            tvPAE.setOnClickListener {
                val intent = Intent(this@Preguntas, Pae::class.java)
                startActivity(intent)
            }
            tvExtra.setOnClickListener {
                val intent = Intent(this@Preguntas, Extra::class.java)
                startActivity(intent)
            }
            tvRecursa.setOnClickListener {
                val intent = Intent(this@Preguntas, Recursa::class.java)
                startActivity(intent)
            }
            tvRepetir.setOnClickListener {
                val intent = Intent(this@Preguntas, Repetir::class.java)
                startActivity(intent)
            }
            tvReinscripciones.setOnClickListener {
                val intent = Intent(this@Preguntas, Reinscripcion::class.java)
                startActivity(intent)
            }
            tvCredeCch.setOnClickListener {
                val intent = Intent(this@Preguntas, CredeCCH::class.java)
                startActivity(intent)
            }
            tvCredeUnam.setOnClickListener {
                val intent = Intent(this@Preguntas, CredeUnam::class.java)
                startActivity(intent)
            }
            tvConstancia.setOnClickListener {
                val intent = Intent(this@Preguntas, Constancia::class.java)
                startActivity(intent)
            }
            tvSeguro.setOnClickListener {
                val intent = Intent(this@Preguntas, Seguro::class.java)
                startActivity(intent)
            }
            tvBeca.setOnClickListener {
                val intent = Intent(this@Preguntas, Becas::class.java)
                startActivity(intent)
            }
            tvCaope.setOnClickListener {
                val intent = Intent(this@Preguntas, Caope::class.java)
                startActivity(intent)
            }
            tvOpciones.setOnClickListener {
                val intent = Intent(this@Preguntas, Opciones::class.java)
                startActivity(intent)
            }
            tvPrestampo.setOnClickListener {
                val intent = Intent(this@Preguntas, Prestamo::class.java)
                startActivity(intent)
            }
        }
    }
}