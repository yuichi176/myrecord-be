package com.example.myrecordbe.app.controller

import com.example.myrecordbe.app.form.PostPostParam
import com.example.myrecordbe.app.form.PostPutParam
import com.example.myrecordbe.app.form.PostSearchParam
import com.example.myrecordbe.domain.dto.PostSelector
import com.example.myrecordbe.domain.entity.Post
import com.example.myrecordbe.domain.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

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
        postService.findAll(PostSelector(user = params.user, collectionName = params.collection_name))

    /**
     * IDで投稿GET
     * @param id ID
     * @return 投稿
     */
    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): Post =
        postService.findOne(id)

    /**
     * 投稿POST
     * @param postParam 投稿POSTパラメータ
     * @return 投稿
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun post(@RequestBody postParam: PostPostParam): Post =
        postService.save(
            Post(
                animeName = postParam.animeName,
                rating = postParam.rating,
                user = postParam.user,
                collectionName = postParam.collectionName
            )
        )

    /**
     * 投稿PUT
     * @param putParam 投稿PUTパラメータ
     * @param id ID
     * @return 投稿
     */
    @PutMapping("/{id}")
    fun put(@RequestBody putParam: PostPutParam,
            @PathVariable id: String): Post =
        postService.save(
            Post(
                id = id,
                animeName = putParam.animeName,
                rating = putParam.rating,
                user = putParam.user,
            )
        )

    /**
     * 投稿削除（物理削除）
     * @param id ID
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) =
        postService.delete(id)
}
