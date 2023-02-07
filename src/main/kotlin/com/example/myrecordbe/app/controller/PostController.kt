package com.example.myrecordbe.app.controller

import com.example.myrecordbe.app.form.PostSearchParam
import com.example.myrecordbe.domain.dto.PostSelector
import com.example.myrecordbe.domain.entity.Post
import com.example.myrecordbe.domain.service.PostService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("posts")
class PostController(
    val postService: PostService
) {
    /**
     * 投稿GET
     * @param params 検索パラメータ
     * @return 投稿一覧
     */
    @GetMapping
    fun get(@ModelAttribute params: PostSearchParam): List<Post> =
        postService.findAll(PostSelector(user = params.user))
}
