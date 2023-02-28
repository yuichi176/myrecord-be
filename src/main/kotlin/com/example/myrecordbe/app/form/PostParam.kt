package com.example.myrecordbe.app.form

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull

/**
 * 投稿パラメータ
 */
data class PostParam (
    val id:String? = null,
    @field:NotBlank @field:Size(max=255) val animeName: String,
    @field:NotNull val rating: Int,
    @field:NotBlank @field:Size(max=255) val user: String,
)