package com.rinosystems.pulsoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat

class InformacionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)
        window.statusBarColor = ContextCompat.getColor(this, R.color.pulsoappcolor)
        window.navigationBarColor =  ContextCompat.getColor(this,R.color.pulsoappcolor)

        val aviso: TextView = findViewById(R.id.aviso)

        aviso.setOnClickListener {
         val intent = Intent(this@InformacionActivity,Aviso::class.java)
            startActivity(intent)

        }
    }
}