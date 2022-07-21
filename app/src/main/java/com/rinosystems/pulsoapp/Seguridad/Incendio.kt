package com.rinosystems.pulsoapp.Seguridad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.barteksc.pdfviewer.PDFView
import com.rinosystems.pulsoapp.R

class Incendio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_incendio)

        val incendio = findViewById<PDFView>(R.id.pdfIncendio)

        incendio.fromAsset("incendio.pdf").load()
    }
}