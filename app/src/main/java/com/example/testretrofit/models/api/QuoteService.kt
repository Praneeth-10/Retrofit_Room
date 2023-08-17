package com.example.testretrofit.models.api

import com.example.testretrofit.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {

    @GET(value = "/quotes")
    suspend fun getQuotes(@Query(value = "page") page: Int) : Response<QuoteList>
}