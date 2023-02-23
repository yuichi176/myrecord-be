package com.example.myrecordbe.app.controller

import com.example.myrecordbe.app.form.PostParam
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
        postService.findAll(PostSelector(user = params.user))

    /**
     * ドキュメントIDで投稿GET
     * @param documentId ドキュメントID
     * @return 投稿
     */
    @GetMapping("/{documentId}")
    fun getByDocumentId(@PathVariable documentId: String): Post =
        postService.findOne(documentId)

    /**
     * 投稿POST
     * @param postParam 投稿POSTパラメータ
     * @return 投稿
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun post(@RequestBody postParam: PostParam): Post =
        postService.save(
            Post(
                animeName = postParam.animeName,
                rating = postParam.rating,
                user = postParam.user,
            )
        )

    /**
     * 投稿PUT
     * @param putParam 投稿PUTパラメータ
     * @param documentId ドキュメントID
     * @return 投稿
     */
    @PutMapping("/{documentId}")
    fun put(@RequestBody putParam: PostParam,
            @PathVariable documentId: String): Post =
        postService.save(
            Post(
                documentId = documentId,
                animeName = putParam.animeName,
                rating = putParam.rating,
                user = putParam.user,
            )
        )

    /**
     * 投稿削除
     * @param documentId ドキュメントID
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{documentId}")
    fun delete(@PathVariable documentId: String) =
        postService.delete(documentId)
}
