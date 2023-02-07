package com.example.myrecordbe.domain.entity

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.cloud.Timestamp

data class Post (
    @JsonProperty("document_id") var documentId:String? = null,
    @JsonProperty("anime_name") val animeName: String? = null,
    @JsonProperty("rating") val rating: Int? = null,
    @JsonProperty("delete_flag") val deleteFlag: Boolean? = null,
    @JsonProperty("user") val user: String? = null,
    @JsonProperty("created_at") val createdAt: Timestamp? = null,
    @JsonProperty("updated_at") val updatedAt: Timestamp? = null,
    @JsonProperty("deleted_at") val deletedAt: Timestamp? = null
)
