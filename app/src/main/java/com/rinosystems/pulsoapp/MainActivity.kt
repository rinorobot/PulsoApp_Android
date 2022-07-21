package com.rinosystems.pulsoapp

import android.app.Service
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View


import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi


import androidx.core.content.ContextCompat

import com.google.android.material.tabs.TabLayoutMediator
import com.rinosystems.pulsoapp.Network.NetworkStatus
import com.rinosystems.pulsoapp.Network.NetworkStatusHelper


import com.rinosystems.pulsoapp.adapters.ViewPagerAdapter
import com.rinosystems.pulsoapp.databinding.ActivityMainBinding

import kotlin.Exception

class MainActivity : AppCompatActivity() {

    lateinit var biding: ActivityMainBinding







    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)




        window.statusBarColor = ContextCompat.getColor(this, R.color.pulsoappcolor)
        window.navigationBarColor =  ContextCompat.getColor(this,R.color.pulsoappcolor)

        NetworkStatusHelper(this@MainActivity).observe(this, {
            findViewById<TextView>(R.id.mensaje_no_internet).visibility = when(it){
                NetworkStatus.Available -> View.GONE
                NetworkStatus.Unavailable -> View.VISIBLE
            }
        })




        val adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)

       biding.vp.adapter = adapter

        TabLayoutMediator(biding.tl,biding.vp){tab, position ->
            when(position){
                0-> {

                    val tab1: TextView= LayoutInflater.from(this).inflate(R.layout.custom_tab,null) as TextView
                    tab1.text = getString(R.string.noticias)
                    tab1.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.notificacion1x,0,0)
                    tab.setCustomView(tab1)
                }
                1->{
                    val tab1: TextView= LayoutInflater.from(this).inflate(R.layout.custom_tab,null) as TextView
                    tab1.text = getString(R.string.exas)
                    tab1.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.quiz1x,0,0)
                    tab.setCustomView(tab1)
                }
                2->{
                    val tab1: TextView= LayoutInflater.from(this).inflate(R.layout.custom_tab,null) as TextView
                    tab1.text = getString(R.string.publis)
                    tab1.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.publicaciones1x,0,0)
                    tab.setCustomView(tab1)
                }
                3->{
                    val tab1: TextView= LayoutInflater.from(this).inflate(R.layout.custom_tab,null) as TextView
                    tab1.text = getString(R.string.info)
                    tab1.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.menu1x,0,0)
                    tab.setCustomView(tab1)
                }
            }

        }.attach()

        biding.informacion.setOnClickListener {
            val intent = Intent(this,InformacionActivity::class.java)
            startActivity(intent)
        }
    }














  
}