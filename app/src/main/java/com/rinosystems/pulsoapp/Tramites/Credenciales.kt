package com.rinosystems.pulsoapp.Tramites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.rinosystems.pulsoapp.R

class Credenciales : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credenciales)

        val btn_unam = findViewById<Button>(R.id.btn_CredeUNAM)
        val btn_cch = findViewById<Button>(R.id.btn_CredeCCH)

        btn_unam.setOnClickListener {
            startActivity(Intent(this,CredeUnam::class.java))
        }
        btn_cch.setOnClickListener {
            startActivity(Intent(this,CredeCCH::class.java))
        }

    }
}