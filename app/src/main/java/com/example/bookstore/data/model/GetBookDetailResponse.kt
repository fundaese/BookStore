package com.example.bookstore.data.model

data class GetBookDetailResponse (
    val code: Int?,
    val message: String?,
    val book: Book?
)