package com.abraham0058.mobpro2m.notify

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.util.Log
import com.abraham0058.mobpro2m.R
import com.google.firebase.messaging.FirebaseMessagingService

class FcmService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        Log.d("FCM", "Token baru: $token")
    }
}
fun createChannel(context: Context) {
    val notificationChannel = NotificationChannel(
        context.getString(R.string.channel_id),
        context.getString(R.string.channel_name),
        NotificationManager.IMPORTANCE_HIGH
    ).apply {
        setShowBadge(false)
        enableLights(true)
        lightColor = Color.RED
        enableVibration(true)
        description = context.getString(R.string.channel_desc)
    }
    val manager = context.getSystemService(NotificationManager::class.java)
    manager?.createNotificationChannel(notificationChannel)
}