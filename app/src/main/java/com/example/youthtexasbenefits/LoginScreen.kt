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
import androidx.compose.runtime.setValue;


@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()){


    val userName by remember {
        loginViewModel.username
    }

    val password by remember {
        loginViewModel.password
    }

    val loginResult by remember{loginViewModel.loginResult}

    val mediumPadding= dimensionResource(R.dimen.padding_medium)

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(mediumPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedTextField(value = userName, onValueChange = {
          loginViewModel.username.value = it
        },
            label = {
                Text(text = stringResource(R.string.username),
                    fontSize =16.sp)
            },
            modifier = Modifier.fillMaxWidth()
        )


        Spacer(modifier = Modifier.padding(mediumPadding))


        OutlinedTextField(value = password, onValueChange = {
           loginViewModel.password.value = it
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
                  loginViewModel.login() },
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

        //handle login result
        when (val result=loginResult ) {
            is LoginViewModel.Result.Success ->
                Text("Success: ${result.message}", color = MaterialTheme.colorScheme.primary)

            is LoginViewModel.Result.Error -> {
                Text("Error: ${result.errorMessage}", color = MaterialTheme.colorScheme.error)
            }
            else -> {}
        }
    }
}