package com.example.homework_5_6m.data.local.db
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homework_5_6m.model.TaskModel

@Database(entities = [TaskModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}