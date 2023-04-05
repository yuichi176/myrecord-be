package com.example.myrecordbe.app.controller

import com.example.myrecordbe.app.form.*
import com.example.myrecordbe.domain.dto.CollectionSelector
import com.example.myrecordbe.domain.entity.Collection
import com.example.myrecordbe.domain.service.CollectionService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("collections")
class CollectionController(
    val collectionService: CollectionService
) {
    /**
     * コレクションGET
     * @param params 検索パラメータ
     * @return コレクション一覧
     */
    @GetMapping
    fun get(@ModelAttribute params: CollectionSearchParam): List<Collection> =
        collectionService.findAll(CollectionSelector(user = params.user))

    /**
     * コレクションPOST
     * @param postParam コレクションPOSTパラメータ
     * @return コレクション
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun post(@RequestBody postParam: CollectionPostParam): Collection =
        collectionService.save(
            Collection(
                name = postParam.name,
                user = postParam.user,
            )
        )

    /**
     * コレクション削除（物理削除）
     * @param id ID
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) =
        collectionService.delete(id)
}