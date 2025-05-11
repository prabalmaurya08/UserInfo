package com.example.jetpack1.mvvm.presentation

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack1.mvvm.domain.model.User
import com.example.jetpack1.mvvm.domain.usecase.CreateUserUseCase
import com.example.jetpack1.mvvm.domain.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val useCase: GetUserUseCase,private val createUserUseCase: CreateUserUseCase): ViewModel(){
    private val _userState= MutableStateFlow<List<User>>(emptyList())
     val userState: StateFlow<List<User>> = _userState

    private val _createUserState= MutableStateFlow<User?>(null)
    val createUserState: MutableStateFlow<User?> =_createUserState
    init {
        loadUsers()
    }

    private fun loadUsers(){
        viewModelScope.launch {
            try{
                val users=useCase()
                _userState.value=users
            }
            catch (e: Exception){

            }
        }
    }

     fun createUser(name:String,email:String){
        viewModelScope.launch {
            try {

                val result=createUserUseCase.execute(name,email)
               result.fold (
                   onSuccess ={_createUserState.value=it},
                   onFailure = {}

               )





            }
            catch (e: Exception){

            }
        }
    }
}