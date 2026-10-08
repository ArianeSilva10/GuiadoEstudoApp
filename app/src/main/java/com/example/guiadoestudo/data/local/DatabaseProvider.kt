package com.example.guiadoestudo.data.local

import android.content.Context
import androidx.room3.Room

object DatabaseProvider {
    @Volatile
    private var INSTANCE: StudyDatabase? = null

    fun getDatabase(context: Context): StudyDatabase {
        return INSTANCE ?: synchronized(this){
            val instance = Room.databaseBuilder(
                context.applicationContext,
                StudyDatabase::class.java,
                "guiadoestudo_database"
            ).build()

            INSTANCE = instance

            instance
        }
    }
}