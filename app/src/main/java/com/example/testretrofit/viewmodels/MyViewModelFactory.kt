package com.example.testretrofit.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testretrofit.models.repository.QuoteRepository

class MyViewModelFactory(private val quoteRepo: QuoteRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyViewModel(quoteRepo) as T
    }
}