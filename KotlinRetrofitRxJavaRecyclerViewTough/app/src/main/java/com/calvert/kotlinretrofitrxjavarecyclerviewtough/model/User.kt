package com.calvert.kotlinretrofitrxjavarecyclerviewtough.model

data class User(
    val `data`: List<Data>,
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)