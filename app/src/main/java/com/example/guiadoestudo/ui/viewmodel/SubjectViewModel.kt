package com.example.guiadoestudo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.guiadoestudo.data.local.Subject
import com.example.guiadoestudo.data.repository.SubjectRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SubjectViewModel(private val repository: SubjectRepository) : ViewModel() {
    private val _subjects = MutableStateFlow<List<Subject>>(emptyList())

    val subjects: StateFlow<List<Subject>> = _subjects

    init {
        loadSubjects()
    }

    fun loadSubjects(){
        viewModelScope.launch {
            _subjects.value = repository.getAllSubjects()
        }
    }

    fun addSubject(name: String, description: String){
        viewModelScope.launch {
            val subject = Subject(
                name = name,
                description = description
            )
            repository.insertSubject(subject)
            loadSubjects()
        }
    }

    fun deleteSubject(subject: Subject){
        viewModelScope.launch {
            repository.deleteSubject(subject)

            loadSubjects()
        }
    }
}