package com.rinosystems.pulsoapp.Seguridad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.barteksc.pdfviewer.PDFView
import com.rinosystems.pulsoapp.R

class Denuncia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_denuncia)
        val denuncia = findViewById<PDFView>(R.id.pdfDenuncia)

       denuncia.fromAsset("denuncia.pdf").load()
    }
}