package com.example.myrecordbe.app.form

import com.fasterxml.jackson.annotation.JsonProperty

data class PostSearchParam(
    val user: String? = null,
    val collection_name: String? = null,
)
