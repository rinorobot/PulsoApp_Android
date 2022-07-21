package com.rinosystems.pulsoapp.Seguridad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.barteksc.pdfviewer.PDFView
import com.rinosystems.pulsoapp.R

class Genero : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genero)

        val genero = findViewById<PDFView>(R.id.pdfGenero)

        genero.fromAsset("violencia.pdf").load()
    }
}