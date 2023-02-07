package com.example.myrecordbe.domain.service

import com.example.myrecordbe.domain.dto.PostSelector
import com.example.myrecordbe.domain.entity.Post
import com.example.myrecordbe.domain.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostServiceImpl(
    private val postRepository: PostRepository
) : PostService {
    override fun findOne(documentId: String): Post {
        TODO("Not yet implemented")
    }

    override fun findAll(selector: PostSelector): List<Post> =
        postRepository.findAll(selector)

    override fun save(post: Post): Post {
        TODO("Not yet implemented")
    }

    override fun delete(documentId: String) {
        TODO("Not yet implemented")
    }
}