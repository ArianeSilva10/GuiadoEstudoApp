package com.example.guiadoestudo.data.local

import androidx.room3.Database
import androidx.room3.RoomDatabase

@Database(
    entities = [Subject::class],
    version = 1,
    exportSchema = false
)

abstract class StudyDatabase : RoomDatabase(){
    abstract fun subjectDao() : SubjectDao
}