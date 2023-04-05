package com.example.myrecordbe.domain.repository

import com.example.myrecordbe.domain.dto.CollectionSelector
import com.example.myrecordbe.domain.entity.Collection

interface CollectionRepository {
    /**
     * 全件取得
     * @param selector 検索条件
     * @return コレクション一覧
     */
    fun findAll(selector: CollectionSelector): List<Collection>

    /**
     * 保存
     * @param collection コレクション
     * @return 投稿
     */
    fun add(collection: Collection): Collection

    /**
     * 削除
     * @param documentId ドキュメントID
     */
    fun delete(documentId: String)
}