package com.example.jetpack1.mvvm.data.remote

import com.example.jetpack1.mvvm.data.model.UserDTO
import retrofit2.Response


import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getUsers(): List<UserDTO> =apiService.getUsers()
    suspend fun createUser(userDTO: UserDTO): Response<UserDTO> =apiService.createUsers(userDTO)




}