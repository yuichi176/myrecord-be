package com.example.myrecordbe.app.form

import com.fasterxml.jackson.annotation.JsonProperty

data class PostSearchParam(
    @JsonProperty("user") val user: String? = null
)
