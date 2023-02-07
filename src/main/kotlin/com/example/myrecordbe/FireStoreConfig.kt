package com.example.myrecordbe

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.FirestoreOptions
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.FileInputStream
import java.io.IOException


@Configuration
class FireStoreConfig {
    @Bean
    @Throws(IOException::class)
    fun getFireStore(@Value("\${firebase.credential.path}") credentialPath: String?): Firestore? {
        val serviceAccount = FileInputStream(credentialPath)
        val credentials = GoogleCredentials.fromStream(serviceAccount)
        val options = FirestoreOptions.newBuilder()
            .setCredentials(credentials).build()
        return options.service
    }
}
