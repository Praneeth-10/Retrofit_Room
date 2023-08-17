package com.example.testretrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testretrofit.R
import com.example.testretrofit.databinding.ActivityMainBinding
import com.example.testretrofit.models.api.QuoteService
import com.example.testretrofit.models.api.RetrofitHelper
import com.example.testretrofit.models.repository.QuoteRepository
import com.example.testretrofit.viewmodels.MyViewModel
import com.example.testretrofit.viewmodels.MyViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var myViewModel: MyViewModel
    lateinit var quoteRepository: QuoteRepository
    lateinit var quoteService: QuoteService
    lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        quoteRepository = QuoteRepository(quoteService)
        myViewModel = ViewModelProvider(this,MyViewModelFactory(quoteRepository)).get(MyViewModel::class.java)

        myViewModel.quotesFetched.observe(this, Observer {
            dataBinding.textShow.text = it.results.toString()
        })
    }
}