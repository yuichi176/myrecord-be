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
    override fun findOne(id: String): Post =
        postRepository.findOne(id) ?: throw NotFoundException()

    override fun findAll(selector: PostSelector): List<Post> =
        postRepository.findAll(selector)

    override fun save(post: Post): Post {
        val id = post.id
        // 存在チェック（更新時）
        if (id != null) {
            postRepository.findOne(id) ?: throw NotFoundException()
        }
        return when (id) {
            null -> postRepository.add(post)
            else -> {
                postRepository.update(post)
                postRepository.findOne(id) ?: throw NotFoundException() // TODO: 更新前のデータが返ってしまう
            }
        }
    }

    override fun delete(id: String) {
        // 存在チェック
        postRepository.findOne(id) ?: throw NotFoundException()
        postRepository.delete(id)
    }
}