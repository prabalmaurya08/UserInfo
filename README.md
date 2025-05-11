# Jetpack Compose MVVM Clean Architecture App 🚀

A modern Android app built with **Jetpack Compose**, following **MVVM** and **Clean Architecture**, integrated with **Hilt**, **Retrofit**, and **Kotlin Coroutines** for making GET and POST API requests.

## 🛠️ Tech Stack

- **Jetpack Compose** – Modern UI toolkit for native Android
- **MVVM Architecture** – Clean separation of concerns
- **Clean Architecture** – Presentation, Domain, Data layers
- **Hilt** – Dependency Injection
- **Retrofit** – Network calls
- **Kotlin Coroutines & Flow** – Asynchronous programming
- **StateFlow** – UI state management
- **Mock API** – [jsonplaceholder.typicode.com](https://jsonplaceholder.typicode.com)

---

## 📂 Project Structure

com.example.jetpack1
│
├── data
│ ├── remote # Retrofit API & RemoteDataSource
│ ├── repository # Implements domain repositories
│ └── dto # UserDTO (Data Transfer Object)
│
├── domain
│ ├── model # Core business model (User)
│ ├── repository # Repository interface
│ └── usecase # UseCases (GetUser, CreateUser)
│
├── di # Hilt DI module
│
├── presentation # ViewModel and UI screen
│
└── MainActivity.kt
