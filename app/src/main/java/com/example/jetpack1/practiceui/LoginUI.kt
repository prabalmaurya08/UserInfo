package com.example.jetpack1.practiceui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun login() {
    var username by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }
    var context= LocalContext.current
    Card() {
        Column (
            modifier = Modifier.padding(8.dp).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
            , verticalArrangement = Arrangement.Center
        ){
            Text(text = "Welcome to App", style = TextStyle(fontSize = 24.sp))


            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Name") },
                placeholder = { Text("Enter your name") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                placeholder = { Text("Enter your name") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            ElevatedButton(
                onClick = {
                    if(username.isNotEmpty() && password.isNotEmpty()){
                       Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context, "Fill all the fields", Toast.LENGTH_SHORT).show()


                    }
                }
                    , modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            ) {
                Text(text = "Login")
            }

        }
    }


}
