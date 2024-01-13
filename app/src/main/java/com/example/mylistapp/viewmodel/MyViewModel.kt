package com.example.mylistapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylistapp.model.DataListModel
import com.example.mylistapp.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private var myRepository: MyRepository) : ViewModel(){

    private var _dataListLiveData = MutableLiveData<DataListModel?>()
    val dataListLiveData: MutableLiveData<DataListModel?> = _dataListLiveData

    fun getDataList(skip: Int) {
        viewModelScope.launch {

            val response = myRepository.getList(skip)

            if (response.isSuccessful)
                _dataListLiveData.postValue(response.body())
            else
                _dataListLiveData.postValue(null)

        }
    }



}