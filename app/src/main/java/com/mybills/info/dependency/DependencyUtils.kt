package com.mybills.info.dependency

import android.content.Context
import com.mybills.info.database.UserInfoDataBase
import com.mybills.info.repository.UserDBRepository

object DependencyUtils {
    lateinit var context : Context

    private fun provideDBInstance() = UserInfoDataBase.getInstance(context).userDao()

    fun fetchUserRepository(): UserDBRepository {
        return  UserDBRepository(provideDBInstance())

    }

    fun setAppContext(context: Context){
        this.context = context
    }

}