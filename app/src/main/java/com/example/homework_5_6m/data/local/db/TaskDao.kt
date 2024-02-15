package com.example.homework_5_6m.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.homework_5_6m.model.TaskModel

@Dao
interface TaskDao {

    @Insert
    fun insert(task: TaskModel)

    @Delete
    fun delete(task: TaskModel)

    @Update
    fun update(task: TaskModel)

    @Query("SELECT * FROM TaskModel ORDER BY uid DESC")
    fun getAll(): List<TaskModel>
}