package com.example.myrecordbe.domain.entity

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.cloud.Timestamp

data class Collection (
    @JsonProperty("id") var id:String? = null,
    @JsonProperty("name") val name: String? = null,
    @JsonProperty("user") val user: String? = null,
    @JsonProperty("created_at") val createdAt: Timestamp? = null,
    @JsonProperty("updated_at") val updatedAt: Timestamp? = null,
    @JsonProperty("deleted_at") val deletedAt: Timestamp? = null
)
