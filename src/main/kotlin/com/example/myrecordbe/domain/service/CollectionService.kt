package com.example.myrecordbe.domain.service

import com.example.myrecordbe.domain.dto.CollectionSelector
import com.example.myrecordbe.domain.entity.Collection

interface CollectionService {
    /**
     * 全件取得
     * @param selector 検索条件
     * @return コレクション一覧
     */
    fun findAll(selector: CollectionSelector): List<Collection>

    /**
     * 保存
     * @param collection コレクション
     * @return コレクション
     */
    fun save(collection: Collection): Collection

    /**
     * 削除
     * @param id ID
     */
    fun delete(id: String)
}