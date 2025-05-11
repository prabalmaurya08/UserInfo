package com.example.jetpack1

import android.annotation.SuppressLint
import android.os.Bundle

import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.activity.ComponentActivity
import androidx.compose.material3.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpack1.mvvm.presentation.UserListScreen
import com.example.jetpack1.mvvm.presentation.UserViewModel
import com.example.jetpack1.mvvm.presentation.createUserScreen
import com.example.jetpack1.practiceui.layout
import com.example.jetpack1.practiceui.login
import com.example.jetpack1.ui.theme.Jetpack1Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jetpack1Theme {
                // ViewModel Inject Karo
                val userViewModel: UserViewModel = hiltViewModel()

                // Apni Composable screen show karo
               // UserListScreen(userViewModel)
                createUserScreen(userViewModel)

            }
        }
    }
}

