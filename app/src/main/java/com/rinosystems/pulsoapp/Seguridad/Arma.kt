package com.rinosystems.pulsoapp.Seguridad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.barteksc.pdfviewer.PDFView
import com.rinosystems.pulsoapp.R

class Arma : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arma)

        val arma_pdf = findViewById<PDFView>(R.id.pdfArma)

        arma_pdf.fromAsset("arma.pdf").load()
    }
}