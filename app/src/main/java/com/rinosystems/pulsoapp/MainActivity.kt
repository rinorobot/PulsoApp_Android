package com.rinosystems.pulsoapp


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import com.rinosystems.pulsoapp.Network.NetworkStatus
import com.rinosystems.pulsoapp.Network.NetworkStatusHelper
import com.rinosystems.pulsoapp.adapters.ViewPagerAdapter
import com.rinosystems.pulsoapp.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    lateinit var biding: ActivityMainBinding
    //private val PERMISSION_REQUEST_CODE = 112

    companion object{
        const val CHANNEL_ID = "notif"
    }


    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // FirebaseApp.initializeApp(this)

        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)

        // Ask for Permission in Android 13
        askNotificationPermission()
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (!shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
                getNotificationPermission()
            }
        }

        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("FCM", "Fetching FCM registration token failed", task.exception)
                return@addOnCompleteListener
            }

            // Obtener el nuevo token de instancia FCM
            val token = task.result
            Log.d("FCM", "FCM Token: $token")

            // Aquí podrías agregar lógica adicional para enviar este token a tu servidor
        }*/








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
                }/*
                3->{
                    val tab1: TextView= LayoutInflater.from(this).inflate(R.layout.custom_tab,null) as TextView
                    tab1.text = getString(R.string.info)
                    tab1.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.menu1x,0,0)
                    tab.setCustomView(tab1)
                }*/
            }

        }.attach()

        biding.informacion.setOnClickListener {
            val intent = Intent(this,InformacionActivity::class.java)
            startActivity(intent)
        }
    }

    private fun askNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            if (ContextCompat.checkSelfPermission(this,Manifest.permission.POST_NOTIFICATIONS)==PackageManager.PERMISSION_GRANTED){

            }else{
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)

            }

        }
    }

    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission(),
        ){isGranted: Boolean ->

        if (isGranted){

        }else{

        }
    }

    fun createNotification(){
        var builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.logo_color_nau)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
    }



   /* fun getNotificationPermission() {
        try {
            if (Build.VERSION.SDK_INT > 32) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    PERMISSION_REQUEST_CODE
                )
            }
        } catch (e: Exception) {
            // Aquí puedes manejar la excepción si es necesario
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.size > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED
                ) {
                    // allow
                    Log.d("body", "granted")
                } else {
                    //deny
                    Log.d("permission","denied")
                }
                return
            }
        }
    }*/

}