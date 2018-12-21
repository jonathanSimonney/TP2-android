package com.example.jonathansimonney.igeneration.fcmMessaging

import android.support.v4.app.NotificationCompat
import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.app.NotificationManager
import android.content.Context
import com.example.jonathansimonney.igeneration.R


class MyFirebaseMessagingService : FirebaseMessagingService() {
    private lateinit var database: DatabaseReference

    private val NEW_ARTICLE_NOTIFICATION_ID = 1
    // Méthode appelée chaque fois que le token change
    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    override fun onNewToken(token: String?) {
        Log.d("jonathanRealToken", "Refreshed token: $token")

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        database = FirebaseDatabase.getInstance().reference
//        sendRegistrationToServer(token)
        database.child("fcmToken").setValue(token).addOnSuccessListener {
            Log.d("jonathanRealToken", "updated token in db: $token")
        }
        .addOnFailureListener {
            Log.e("jonathanRealToken", "refused refresh: $it")
        }
    }

    override fun onMessageReceived(message: RemoteMessage?) {
        // On récupère les données envoyées
        message?.data
        Log.d("jonathanMessaging", message?.data.toString())
        val notificationTitle = message?.data?.get("title")
        val notificationContent = "Découvrez le dernier article écrit par " + message?.data?.get("author")

        val newArticleNotification = NotificationCompat.Builder(applicationContext, "newArticleChannel")
                .setContentTitle(notificationTitle)
                .setContentText(notificationContent)
                .setSmallIcon(R.drawable.new_icon)
                .build()

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(NEW_ARTICLE_NOTIFICATION_ID, newArticleNotification)
    }
}