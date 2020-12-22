package com.mybills.info.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mybills.info.dependency.DependencyUtils
import com.mybills.info.repository.UserDBRepository
import kotlinx.coroutines.Dispatchers


class UserViewModelFactory : ViewModelProvider.Factory {
    lateinit var userDBRepository: UserDBRepository
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        userDBRepository = DependencyUtils.fetchUserRepository()
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(Dispatchers.IO,userDBRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}