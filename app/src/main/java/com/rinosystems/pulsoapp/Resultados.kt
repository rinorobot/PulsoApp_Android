package com.rinosystems.pulsoapp

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.rinosystems.pulsoapp.databinding.ActivityMainBinding
import com.rinosystems.pulsoapp.databinding.ActivityResultadosBinding
import com.rinosystems.pulsoapp.fragments.ExamenesFragment

import java.math.RoundingMode
import java.text.DecimalFormat


class Resultados : AppCompatActivity() {

    lateinit var binding: ActivityResultadosBinding
    lateinit var bindind2: ExamenesFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadosBinding.inflate(layoutInflater)

        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.pulsoappcolor)
        window.navigationBarColor =  ContextCompat.getColor(this,R.color.pulsoappcolor)

        val calif = intent.getFloatExtra("resul", 0.0F)
        val nombre = intent.getStringExtra("nombre")
        val lista_correctas = intent.getSerializableExtra("lista_correctas")
        val lista_incorrectas = intent.getSerializableExtra("lista_incorrectas")

        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING



        binding.btnResultadosExamen.setOnClickListener {
        val intent = Intent(this,MainActivity::class.java)

           startActivity(intent)
           this.finish()

        }


        binding.btnCompartirResultados.setOnClickListener {
            var emoji: String = ""
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND

                if (calif<6){
                    emoji = "\uD83D\uDE48"
                }
                if (calif>=6&&calif<=8.4){
                    emoji = "\uD83D\uDE2C"
                }
                if (calif>8.4){
                    emoji = "\uD83D\uDE0E"
                }


                putExtra(Intent.EXTRA_TEXT, "Obtuve ${df.format(calif)} en el examen de ${nombre} "+emoji+" de @PulsoApp")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, "Compartir en...")
            startActivity(shareIntent)
        }


        binding.tvResultadoExamen.text = "La calificación es de ${df.format(calif)}"

        if (calif<6){
            binding.animacionResultados.setAnimation(R.raw.sad)

            binding.tvMensajeExamen.text = "Estudiando lo lograrás"
            binding.tvRespuestasBuenas.text = "Respuestas correctas: "+lista_correctas.toString()
            binding.tvRespuestasMalas.text = "Respuestas incorrectas: "+lista_incorrectas.toString()

        }
        if (calif>=6&&calif<=8.4){
            binding.animacionResultados.setAnimation(R.raw.try_again)

            binding.tvMensajeExamen.text = "Muy bien pero puedes hacerlo mejor"
            binding.tvRespuestasBuenas.text = "Respuestas correctas: "+lista_correctas.toString()
            binding.tvRespuestasMalas.text = "Respuestas incorrectas:"+lista_incorrectas.toString()
        }
        if (calif>8.4){
            binding.animacionResultados.setAnimation(R.raw.congrats)

            binding.tvMensajeExamen.text = "Excelente resultado"
            binding.tvRespuestasBuenas.text = "Respuestas correctas: "+lista_correctas.toString()
            binding.tvRespuestasMalas.text = "Respuestas incorrectas: "+lista_incorrectas.toString()
        }

        binding.animacionResultados.playAnimation()




    }
}