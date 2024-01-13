package com.example.mylistapp.ui

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.mylistapp.databinding.ActivityDetailsBinding
import com.example.mylistapp.model.Constants
import com.example.mylistapp.model.User
import com.example.mylistapp.viewmodel.MyViewModel
import com.squareup.picasso.Picasso

class DetailScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private val viewModel : MyViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = intent.getSerializableExtra("data",User::class.java)
        setData(data)
    }

    private fun setData(data: User?) {
        binding.user = data
        Picasso.get().load(data?.image).into(binding.imageView)
        binding.container.setBackgroundColor(Color.parseColor(Constants().colorList.random()))

    }

}
