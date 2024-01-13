package com.example.mylistapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mylistapp.adapter.MyListAdapter
import com.example.mylistapp.databinding.ActivityMainBinding
import com.example.mylistapp.model.DataListModel
import com.example.mylistapp.model.User
import com.example.mylistapp.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : MyViewModel by viewModels()
    var skip : Int = 0
    var maxLimit = 0
    private val myListAdapter = MyListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        initAdapter()
    }

    private fun initAdapter() {
        binding.recyclerview.adapter = myListAdapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.setHasFixedSize(true)
        myListAdapter.onItemClick = { user ->
            startActivity(Intent(this,DetailScreenActivity::class.java).putExtra("data",user))
        }
        binding.recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (!recyclerView.canScrollVertically(1)){
                    skip += 10
                    if (skip <= maxLimit) {
                        binding.progress.visibility = View.VISIBLE
                        viewModel.getDataList(skip)
                    }
                }
            }
        })
    }

    private fun initViewModel(){
        viewModel.dataListLiveData.observe(this) {
            if (it != null){
                maxLimit = it.total
                setAdapterData(it)
            }
        }
        viewModel.getDataList(skip)
    }

    private fun setAdapterData(dataListModel: DataListModel) {
        binding.progress.visibility = View.GONE
        val userData = mutableListOf<User>()
        userData.addAll(dataListModel.users.toMutableList())
        myListAdapter.setData(userData)
    }


}




