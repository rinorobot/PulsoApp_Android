package com.rinosystems.pulsoapp.Seguridad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.barteksc.pdfviewer.PDFView
import com.rinosystems.pulsoapp.R

class Fuga : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fuga)

        val fuga = findViewById<PDFView>(R.id.pdfFuga)

        fuga.fromAsset("fuga.pdf").load()
    }
}