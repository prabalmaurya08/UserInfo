package com.example.jetpack1.mvvm.domain.repository

import com.example.jetpack1.mvvm.domain.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>
    suspend fun createUsers(user: User): Result<User>
}