package com.example.jetpack1.mvvm.domain.usecase

import com.example.jetpack1.mvvm.domain.model.User
import com.example.jetpack1.mvvm.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val repository: UserRepository) {
//    Use invoke() when:
//
//    You just want to fetch data without any parameters.
    suspend operator fun invoke(): List<User> {
        return repository.getUsers()
    }
}