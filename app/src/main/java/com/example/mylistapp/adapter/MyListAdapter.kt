package com.example.mylistapp.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mylistapp.databinding.ListLayoutBinding
import com.example.mylistapp.model.Constants
import com.example.mylistapp.model.User
import com.squareup.picasso.Picasso

class MyListAdapter : RecyclerView.Adapter<MyListAdapter.MyListViewHolder>() {

    private lateinit var binding: ListLayoutBinding
    var onItemClick: ((User) -> Unit)? = null
    private var userList: MutableList<User> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListViewHolder {
        binding = ListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyListViewHolder, position: Int) {
        val largeNews = userList[position]
        holder.bind(largeNews,position)
    }

    override fun getItemCount(): Int = userList.size

    fun setData(newList : MutableList<User>){
        userList.addAll(newList)
        notifyItemInserted(userList.size)
    }

    inner class MyListViewHolder(
        private val binding: ListLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User, position: Int) {

            if (position%2 ==0)
                binding.container.layoutDirection = View.LAYOUT_DIRECTION_RTL
            else
                binding.container.layoutDirection = View.LAYOUT_DIRECTION_LTR

            binding.container.setBackgroundColor(Color.parseColor(Constants().colorList.random()))
            binding.user = user
            Picasso.get().load(user.image).into(binding.imageView)
            itemView.setOnClickListener {
                onItemClick?.invoke(user)
            }
        }
    }



}

