package com.example.testretrofit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testretrofit.models.QuoteList
import com.example.testretrofit.models.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(val quoteRepo: QuoteRepository) : ViewModel(){
    init {
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepo.getQuotes(1)
        }
    }


    val quotesFetched : LiveData<QuoteList>
        get() = quoteRepo.quotes
}