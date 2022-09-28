package com.rinosystems.pulsoapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MotionEvent
import android.widget.LinearLayout
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
      /*  Thread.sleep(1000)
        startActivity(Intent(this,MainActivity::class.java))
        finish()*/

        window.statusBarColor = ContextCompat.getColor(this, R.color.pulsoappcolor)
        window.navigationBarColor =  ContextCompat.getColor(this,R.color.pulsoappcolor)

        val videoHolder: VideoView = findViewById(R.id.videoview)

        try {

          //  val videoHolder = VideoView(this)
           // setContentView(videoHolder)
            val video: Uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.intro)
            videoHolder.setVideoURI(video)



            videoHolder.setOnCompletionListener { jump() }
            videoHolder.start()
        } catch (ex: Exception) {
            jump()
        }


    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        jump()
        return true
    }



    private fun jump() {
        if (isFinishing) return
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}