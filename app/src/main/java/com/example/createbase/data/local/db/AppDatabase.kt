package com.example.createbase.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase

//@Database(entities = [User::class, Question::class, Option::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
//
//    abstract fun optionDao(): OptionDao
//
//    abstract fun questionDao(): QuestionDao
//
//    abstract fun userDao(): UserDao
}
