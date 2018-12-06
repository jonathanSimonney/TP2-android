package com.example.jonathansimonney.igeneration.fcmMessaging

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage



class MyFirebaseMessagingService : FirebaseMessagingService() {
    // Méthode appelée chaque fois que le token change
    override fun onNewToken(token: String?) {
        // todo Envoyer le token vers le serveur
    }

    override fun onMessageReceived(message: RemoteMessage?) {
        // On récupère les données envoyées
        message?.data
    }
}