package com.example.myrecordbe.app.form

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

/**
 * コレクション投稿パラメータ
 */
data class CollectionPostParam (
    @field:NotBlank
    @field:Size(max=255)
    @JsonProperty("name") val name: String,

    @field:NotBlank
    @field:Size(max=255)
    @JsonProperty("user") val user: String,
)
