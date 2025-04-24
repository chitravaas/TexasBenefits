package com.example.youthtexasbenefits


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.youthtexasbenefits.ui.LoginViewModel
import androidx.compose.runtime.setValue


@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()){

    val loginMessage by loginViewModel._loginMessage

    var userName by remember { mutableStateOf("") }
    var  password by remember { mutableStateOf("") }

    val mediumPadding= dimensionResource(R.dimen.padding_medium)

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(mediumPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
       OutlinedTextField(value = userName, onValueChange = {
           userName=it
        }
        )

        Spacer(modifier = Modifier.padding(mediumPadding))

        OutlinedTextField(value = password, onValueChange = {
            password = it
        },
            label = {
                Text(text = stringResource(R.string.password),
                    fontSize = 16.sp)
            },
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(mediumPadding))

        Button(
            modifier = Modifier
                .height(50.dp)
                .width(350.dp),
            onClick = {
                loginViewModel.login(userName,password) },
            enabled = true,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2D4356),
                contentColor = Color.Green,
                disabledContainerColor = Color.LightGray,
                disabledContentColor = Color.White
            )
        ) {
            Text(text = stringResource(R.string.login),
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.padding(mediumPadding))

        Text(
            text = loginMessage,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}