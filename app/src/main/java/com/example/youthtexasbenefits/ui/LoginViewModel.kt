package com.example.youthtexasbenefits.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    var username = mutableStateOf("")
    var password = mutableStateOf("")

    var loginResult = mutableStateOf<Result?>(null)

    fun login() {
        viewModelScope.launch {
            val result = if (username.value== "user3000" && password.value =="12345"){
                Result.Success("Login is successful")
            }else {
                Result.Error("Login is unsuccessful")
            }
            loginResult.value=result
        }
    }

    sealed class Result {
        data class Success(val message:String) :Result()
        data class Error(val errorMessage:String) :Result()
    }
}