package com.example.testretrofit.models.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.testretrofit.models.QuoteList
import com.example.testretrofit.models.Result

@Dao
interface QuoteDAO {

    @Insert
    suspend fun addQuotes(quotes:List<Result>)

    @Query("select * from quotesTable")
    suspend fun getQuotes() : List<Result>

}