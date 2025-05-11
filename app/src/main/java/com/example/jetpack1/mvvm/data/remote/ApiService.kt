package com.example.jetpack1.mvvm.data.remote

import com.example.jetpack1.mvvm.data.model.UserDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("users")
    suspend fun getUsers():List<UserDTO>

    @POST("users")
    suspend fun createUsers(@Body userDTO: UserDTO): Response<UserDTO>


}