package com.calvert.kotlinretrofitrecyclerview.model

data class UserModel(val page: Int, val per_page: Int, val total: Int, val total_pages: Integer, val data: Array<Users>)