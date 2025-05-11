package com.example.jetpack1.mvvm.data.repository

import com.example.jetpack1.mvvm.data.model.UserDTO
import com.example.jetpack1.mvvm.data.remote.RemoteDataSource
import com.example.jetpack1.mvvm.domain.model.User
import com.example.jetpack1.mvvm.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(private val remoteDataSource: RemoteDataSource):UserRepository {
    override suspend fun getUsers(): List<User> {
        return remoteDataSource.getUsers().map { it.toDomain() }
    }

    override suspend fun createUsers(user: User): Result<User> {
        return try {
            val userDTO= UserDTO.fromDomain(user)
            val response=remoteDataSource.createUser(userDTO)
            if (response.isSuccessful) {
                response.body()?.let {
                    Result.success(it.toDomain())
                } ?: Result.failure(Exception("Empty body"))
            } else {
                Result.failure(Exception("Error: ${response.code()}"))
            }

        }
        catch (e: Exception){
            Result.failure(e)

        }
    }


}