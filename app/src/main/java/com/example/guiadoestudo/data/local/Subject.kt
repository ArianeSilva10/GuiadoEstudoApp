package com.example.guiadoestudo.data.local

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "subjects")
data class Subject(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String
)