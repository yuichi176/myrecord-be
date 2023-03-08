package com.example.myrecordbe.domain.repository

import com.example.myrecordbe.domain.dto.PostSelector
import com.example.myrecordbe.domain.entity.Post

interface PostRepository {
    /**
     * ドキュメントIDで一件取得
     * @param documentId ドキュメントID
     * @return 投稿
     */
    fun findOne(documentId: String): Post?

    /**
     * 全件取得
     * @param selector 検索条件
     * @return 投稿一覧
     */
    fun findAll(selector: PostSelector): List<Post>

    /**
     * 保存
     * @param post 投稿
     * @return 投稿
     */
    fun add(post: Post): Post

    /**
     * 更新
     * @param post 投稿
     */
    fun update(post: Post)

    /**
     * 削除
     * @param documentId ドキュメントID
     */
    fun delete(documentId: String)
}