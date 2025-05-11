package com.example.jetpack1.mvvm.data.model

import com.example.jetpack1.mvvm.domain.model.User

data class UserDTO(
    val id:Int?=null,
    val name:String,
    val email:String
){
    fun toDomain():User {
        return User(
            id = id,
            name = name,
            email = email
        )
    }

    companion object{
        fun fromDomain(user:User): UserDTO{
            return UserDTO(
                id = user.id,
                name = user.name,
                email = user.email
            )
        }
    }
}
