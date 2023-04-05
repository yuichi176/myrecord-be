package com.example.myrecordbe.domain.service

import com.example.myrecordbe.domain.dto.CollectionSelector
import com.example.myrecordbe.domain.entity.Collection
import com.example.myrecordbe.domain.repository.CollectionRepository
import org.springframework.stereotype.Service

@Service
class CollectionServiceImpl(
    private val collectionRepository: CollectionRepository
) : CollectionService {
    override fun findAll(selector: CollectionSelector): List<Collection> =
        collectionRepository.findAll(selector)

    override fun save(collection: Collection): Collection =
        collectionRepository.add(collection)

    override fun delete(id: String) =
        collectionRepository.delete(id)
}
