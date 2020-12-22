package com.mybills.info.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mybills.info.model.User


@Database(entities = [User::class], version = 2)
abstract class UserInfoDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {

        @Volatile private var INSTANCE: UserInfoDataBase? = null

        fun getInstance(context: Context): UserInfoDataBase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                UserInfoDataBase::class.java, "MyBills.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}