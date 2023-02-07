package com.example.myrecordbe.domain.repository

import com.example.myrecordbe.domain.dto.PostSelector
import com.example.myrecordbe.domain.entity.Post
import com.google.api.core.ApiFuture
import com.google.cloud.firestore.CollectionReference
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.QueryDocumentSnapshot
import com.google.cloud.firestore.QuerySnapshot
import org.springframework.stereotype.Repository


@Repository
class PostRepositoryImpl(
    private val db: Firestore
) : PostRepository {

    val postCollectionRef: CollectionReference = db.collection("posts")

    override fun findOne(documentId: String): Post {
        TODO("Not yet implemented")
    }

    override fun findAll(selector: PostSelector): List<Post> {
        val future: ApiFuture<QuerySnapshot> = if (selector.user == null) {
            postCollectionRef.whereEqualTo("deleteFlag", false).get()
        } else {
            postCollectionRef.whereEqualTo("user", selector.user).whereEqualTo("deleteFlag", false).get()
        }
        val documents: List<QueryDocumentSnapshot> = future.get().documents
        val posts = documents.map { doc ->
            val post = doc.toObject(Post::class.java)
            post.documentId = doc.id
            post
        }.toList()
        return posts
    }

    override fun add(post: Post): Post {
        TODO("Not yet implemented")
    }

    override fun update(post: Post): Post {
        TODO("Not yet implemented")
    }

    override fun delete(documentId: String) {
        TODO("Not yet implemented")
    }
}