package com.example.guiadoestudo.data.repository

import com.example.guiadoestudo.data.local.Subject
import com.example.guiadoestudo.data.local.SubjectDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SubjectRepository(
    private val subjectDao: SubjectDao
) {
    suspend fun getAllSubjects(): List<Subject>{
        return withContext(Dispatchers.IO){
            subjectDao.getAllSubjects()
        }
    }

    suspend fun insertSubject(subject: Subject){
        withContext(Dispatchers.IO){
            subjectDao.insertSubject(subject)
        }
    }

    suspend fun updateSubject(subject: Subject){
        withContext(Dispatchers.IO){
            subjectDao.updateSubject(subject)
        }
    }

    suspend fun deleteSubject(subject: Subject){
        withContext(Dispatchers.IO){
            subjectDao.deleteSubject(subject)
        }
    }
}