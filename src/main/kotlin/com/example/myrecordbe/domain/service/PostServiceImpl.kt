package com.example.myrecordbe.domain.service

import com.example.myrecordbe.domain.dto.PostSelector
import com.example.myrecordbe.domain.entity.Post
import com.example.myrecordbe.domain.exception.NotFoundException
import com.example.myrecordbe.domain.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostServiceImpl(
    private val postRepository: PostRepository
) : PostService {
    override fun findOne(documentId: String): Post =
        postRepository.findOne(documentId) ?: throw NotFoundException()

    override fun findAll(selector: PostSelector): List<Post> =
        postRepository.findAll(selector)

    override fun save(post: Post): Post {
        val documentId = post.documentId
        // 存在チェック（更新時）
        if (documentId != null) {
            postRepository.findOne(documentId) ?: throw NotFoundException()
        }
        return when (documentId) {
            null -> postRepository.add(post)
            else -> postRepository.update(post)
        }
    }

    override fun delete(documentId: String) {
        // 存在チェック
        postRepository.findOne(documentId) ?: throw NotFoundException()
        postRepository.delete(documentId)
    }
}