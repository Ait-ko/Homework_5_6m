package com.example.homework_5_6m.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class TaskModel(
    @PrimaryKey(autoGenerate = true)
    val uid:Int? = null,
    val title: String? = null,
    val description: String? = null
): Serializable