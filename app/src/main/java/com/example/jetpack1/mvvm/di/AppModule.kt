package com.example.jetpack1.mvvm.di

import com.example.jetpack1.mvvm.data.remote.ApiService
import com.example.jetpack1.mvvm.data.remote.RemoteDataSource
import com.example.jetpack1.mvvm.data.repository.UserRepositoryImp
import com.example.jetpack1.mvvm.domain.repository.UserRepository
import com.example.jetpack1.mvvm.domain.usecase.CreateUserUseCase
import com.example.jetpack1.mvvm.domain.usecase.GetUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService{
        return Retrofit.Builder().
                baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).
                build().create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource{
        return RemoteDataSource(apiService)
    }
    @Provides
    @Singleton
    fun provideUserRepository(remoteDataSource: RemoteDataSource): UserRepository{
        return UserRepositoryImp(remoteDataSource)
    }
    @Provides
    @Singleton
    fun provideUseCase(repository: UserRepository): GetUserUseCase{
        return GetUserUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCreateUserUseCase(repository: UserRepository): CreateUserUseCase{
        return CreateUserUseCase(repository)
    }
}