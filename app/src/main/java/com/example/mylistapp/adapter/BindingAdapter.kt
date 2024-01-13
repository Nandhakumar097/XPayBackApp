package com.example.mylistapp.adapter

import android.annotation.SuppressLint
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.example.mylistapp.model.User

@BindingAdapter("setAddress")
fun setAddress(appCompatTextView: AppCompatTextView, user: User){

    val address = user.address.address.plus(" ")
        .plus(user.address.city).plus(" ")
        .plus(user.address.postalCode).plus(" ")
        .plus(user.address.state)
    appCompatTextView.text = address

}

@SuppressLint("SetTextI18n")
@BindingAdapter("setAge")
fun setAge(appCompatTextView: AppCompatTextView, user: User){
    appCompatTextView.text = "Age: ${user.age}"
}

@SuppressLint("SetTextI18n")
@BindingAdapter("setHeight")
fun setHeight(appCompatTextView: AppCompatTextView, user: User){
    appCompatTextView.text = "Height: ${user.height}cm"
}

@SuppressLint("SetTextI18n")
@BindingAdapter("setWeight")
fun setWeight(appCompatTextView: AppCompatTextView, user: User){
    appCompatTextView.text = "Weight: ${user.weight}kg"
}

@SuppressLint("SetTextI18n")
@BindingAdapter("setGender")
fun setGender(appCompatTextView: AppCompatTextView, user: User){
    appCompatTextView.text = "Gender: ${user.gender}"
}

@SuppressLint("SetTextI18n")
@BindingAdapter("setFullName")
fun setFullName(appCompatTextView: AppCompatTextView, user: User){
    appCompatTextView.text = "${user.firstName} ${user.lastName} ${user.maidenName}"
}


@SuppressLint("SetTextI18n")
@BindingAdapter("setCardNo")
fun setCardNo(appCompatTextView: AppCompatTextView, user: User){
    val lastFour = user.bank.cardNumber.takeLast(4)
    appCompatTextView.text = "Acc.No: XXXXXX${lastFour}"
}

@SuppressLint("SetTextI18n")
@BindingAdapter("setExpiry")
fun setExpiry(appCompatTextView: AppCompatTextView, user: User){
    appCompatTextView.text = "Expiry: ${user.bank.cardExpire}"
}

@SuppressLint("SetTextI18n")
@BindingAdapter("setCardType")
fun setCardType(appCompatTextView: AppCompatTextView, user: User){
    appCompatTextView.text = "Card type: ${user.bank.cardType}"
}