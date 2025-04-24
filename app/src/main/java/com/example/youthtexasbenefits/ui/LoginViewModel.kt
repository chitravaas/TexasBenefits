package com.example.youthtexasbenefits.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.security.KeyStore.TrustedCertificateEntry

class LoginViewModel : ViewModel() {

    val _loginMessage = mutableStateOf("Please log in")

    fun login(userName : String, password : String) {
        viewModelScope.launch {
            val result = if (userName == "user3000" && password=="12345"){
                _loginMessage.value = " Login is Successful"
            } else {
                _loginMessage.value=" Login is unsuccessful"
            }
        }
    }
}