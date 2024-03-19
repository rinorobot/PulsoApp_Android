package com.rinosystems.pulsoapp.Notificaciones


import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.rinosystems.pulsoapp.MainActivity
import com.rinosystems.pulsoapp.R
import kotlin.random.Random


class MyFirebaseMessagingService: FirebaseMessagingService() {
    private val random = Random
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        /*message.notification?.let {
            NotificationManager.notificationLiveData.postValue("Acabas de recibir la sig. noticia:"+ message.notification!!.body.toString()+". Revisa la sección de noticias para más detalles.")
        }*/
        message.notification?.let {message ->
            Log.d("FCM title","${message.title}")
            Log.d("FCM body","${message.body}")
            sendNotification(message)
        }


    }

    private fun sendNotification(message: RemoteMessage.Notification){
        val intent = Intent(this,MainActivity::class.java).apply {
            addFlags(FLAG_ACTIVITY_CLEAR_TOP)
        }
        val pendingIntent = PendingIntent.getActivity(this,0,intent,FLAG_IMMUTABLE)

        val channelId = this.getString(R.string.default_notification_id)
        val notificationBuilder = NotificationCompat.Builder(this,channelId)
            .setContentTitle(message.title)
            .setContentText(message.body)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setSmallIcon(R.drawable.logo_color_nau)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)

        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(channelId,CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel)
        }
        manager.notify(random.nextInt(),notificationBuilder.build())


    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }

    companion object{
        const val CHANNEL_NAME = "FCM notification channel"
    }

    /*override fun handleIntent(intent: Intent) {
        try {
            if (intent.extras != null) {
                val builder = RemoteMessage.Builder("MessagingService")
                for (key in intent.extras!!.keySet()) {
                    builder.addData(key!!, intent.extras!![key].toString())
                }
                onMessageReceived(builder.build())
            } else {
                super.handleIntent(intent)
            }
        } catch (e: Exception) {
            super.handleIntent(intent)
        }
    }*/

}