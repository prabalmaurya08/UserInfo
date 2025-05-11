package com.example.jetpack1.mvvm.presentation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpack1.mvvm.domain.model.User


@Composable
fun UserListScreen(
    viewModel: UserViewModel = hiltViewModel()

) {
    val users by viewModel.userState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()){
        when{
            users.isNotEmpty() ->{
                LazyColumn {
                   items(users) { user->

                       UserItemCard(user = user)

                   }
                }
            }
        }
    }




}

@Composable
fun UserItemCard(user: User){
    Card (modifier = Modifier.fillMaxWidth().padding(8.dp)){
        Column(modifier =Modifier.padding(8.dp)) {
            Text(text = user.name)
            Text(text = user.email)
        }
    }
}
