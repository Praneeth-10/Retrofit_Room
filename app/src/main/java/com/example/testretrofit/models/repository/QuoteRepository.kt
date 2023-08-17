package com.example.testretrofit.models.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testretrofit.models.QuoteList
import com.example.testretrofit.models.api.QuoteService

class QuoteRepository(val quoteServ: QuoteService) {


    private val quotesLive = MutableLiveData<QuoteList>()

    val quotes : LiveData<QuoteList>
        get() = quotesLive

    @WorkerThread
    suspend fun getQuotes(page:Int){
        val result = quoteServ.getQuotes(page)
        if(result?.body() != null){
            quotesLive.postValue(result.body())
        }
    }

}