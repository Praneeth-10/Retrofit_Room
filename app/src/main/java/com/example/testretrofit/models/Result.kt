package com.example.testretrofit.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("quotesTable")
data class Result(
    @PrimaryKey(autoGenerate = true)
    val quoteId : String,
    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int
)