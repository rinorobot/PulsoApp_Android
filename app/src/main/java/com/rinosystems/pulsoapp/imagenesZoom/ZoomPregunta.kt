package com.rinosystems.pulsoapp.imagenesZoom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import androidx.constraintlayout.motion.widget.OnSwipe
import androidx.core.net.toUri
import com.rinosystems.pulsoapp.R
import com.rinosystems.pulsoapp.databinding.ActivityZoomPreguntaBinding
import com.squareup.picasso.Picasso

class ZoomPregunta : AppCompatActivity() {

    lateinit var binding: ActivityZoomPreguntaBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZoomPreguntaBinding.inflate(layoutInflater)
        setContentView(binding.root)





        binding.apply {
            val imagen = intent.getStringExtra("imagen")
            Picasso.get().load(imagen).into(imgZoomPregunta)


           




        }
    }



}


