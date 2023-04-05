package com.example.myrecordbe.app.form

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull

/**
 * 投稿PUTパラメータ
 */
data class PostPutParam (
    @JsonProperty("id") val id:String? = null,

    @field:NotBlank
    @field:Size(max=255)
    @JsonProperty("anime_name") val animeName: String,

    @field:NotNull
    @JsonProperty("rating") val rating: Int,

    @field:NotBlank
    @field:Size(max=255)
    @JsonProperty("user") val user: String,
)