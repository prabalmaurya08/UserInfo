package com.example.jetpack1.mvvm.domain.usecase

import com.example.jetpack1.mvvm.domain.model.User
import com.example.jetpack1.mvvm.domain.repository.UserRepository
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(private val userRepository: UserRepository) {
//    Use execute() when:
//
//    You need to perform an action that requires a parameter.
//
//    You want to handle success or failure of that operation (like creating a user).
//
//    You want to wrap the result in a Result (success or failure).
suspend fun execute(name:String,email:String): Result<User>{
    val newUser=User(name = name, email = email)
    return userRepository.createUsers(newUser)
}
}