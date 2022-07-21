package com.rinosystems.pulsoapp.Tramites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rinosystems.pulsoapp.R
import com.rinosystems.pulsoapp.databinding.ActivityTramitesBinding

class Tramites : AppCompatActivity() {
    lateinit var binding: ActivityTramitesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTramitesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnCredenciales.setOnClickListener {
                startActivity(Intent(this@Tramites,Credenciales::class.java))
            }

            btnRecursa.setOnClickListener {
                startActivity(Intent(this@Tramites,Recursa::class.java))
            }
            btnPae.setOnClickListener {
                startActivity(Intent(this@Tramites,Pae::class.java))
            }
            btnExtra.setOnClickListener {
                startActivity(Intent(this@Tramites,Extra::class.java))
            }
            btnComprobante.setOnClickListener {
                startActivity(Intent(this@Tramites,Comprobante::class.java))
            }
            btnSeguro.setOnClickListener {
                startActivity(Intent(this@Tramites,Seguro::class.java))
            }
            btnCertificado.setOnClickListener {
                startActivity(Intent(this@Tramites,Certificado::class.java))
            }
            btnSeleccion.setOnClickListener {
                startActivity(Intent(this@Tramites,Seleccion::class.java))
            }
            btnBecas.setOnClickListener {
                startActivity(Intent(this@Tramites,Becas::class.java))
            }
            btnConstancias.setOnClickListener {
                startActivity(Intent(this@Tramites,Constancia::class.java))
            }
            btnInscripcion.setOnClickListener {
                startActivity(Intent(this@Tramites,Inscripcion::class.java))
            }
            btnOpciones.setOnClickListener {
                startActivity(Intent(this@Tramites,Opciones::class.java))
            }
            btnPase.setOnClickListener {
                startActivity(Intent(this@Tramites,Pase::class.java))
            }




        }
    }
}