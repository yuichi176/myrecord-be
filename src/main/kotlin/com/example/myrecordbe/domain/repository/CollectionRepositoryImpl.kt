package com.example.myrecordbe.domain.repository

import com.example.myrecordbe.domain.dto.CollectionSelector
import com.example.myrecordbe.domain.entity.Collection
import com.google.cloud.firestore.FieldValue
import com.google.cloud.firestore.Firestore
import org.springframework.stereotype.Repository

@Repository
class CollectionRepositoryImpl(
    private val db: Firestore
) : CollectionRepository {

    val collectionCollectionRef = db.collection("collections")

    override fun findAll(selector: CollectionSelector): List<Collection> {
        val future = when (selector.user) {
            null -> collectionCollectionRef.get()
            else -> collectionCollectionRef.whereEqualTo("user", selector.user).get()
        }
        val docs = future.get().documents
        val collections = docs.map { doc ->
            val collection = doc.toObject(Collection::class.java)
            collection.id = doc.id
            collection
        }.toList()
        return collections
    }

    override fun add(post: Collection): Collection {
        val data = mapOf(
            "name" to post.name,
            "user" to post.user,
            "createdAt" to FieldValue.serverTimestamp(),
            "updatedAt" to FieldValue.serverTimestamp(),
            "deletedAt" to null
        )
        val docRefFuture = collectionCollectionRef.add(data)

        val docRef = docRefFuture.get()
        val future = docRef.get()
        val doc = future.get()
        val collection = doc.toObject(Collection::class.java) ?: throw RuntimeException()
        collection.id = doc.id
        return collection
    }

    override fun delete(documentId: String) {
        collectionCollectionRef.document(documentId).delete()
    }
}