package com.example.androidintermediate.advanced_database.database_relation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.androidintermediate.advanced_database.database_relation.database.Student
import com.example.androidintermediate.advanced_database.database_relation.database.StudentAndUniversity
import com.example.androidintermediate.advanced_database.database_relation.database.StudentWithCourse
import com.example.androidintermediate.advanced_database.database_relation.database.UniversityAndStudent
import kotlinx.coroutines.launch

class DatabaseRelationViewModel(private val repository: StudentRepository) : ViewModel() {
    init {
        insertAllData()
    }

    fun getAllStudent(): LiveData<List<Student>> = repository.getAllStudent()
    fun getAllStudentAndUniversity():
            LiveData<List<StudentAndUniversity>> = repository.getAllStudentAndUniversity()

    fun getAllUniversityAndStudent(): LiveData<List<UniversityAndStudent>> =
        repository.getAllUniversityAndStudent()

    fun getAllStudentWithCourse(): LiveData<List<StudentWithCourse>> =
        repository.getAllStudentWithCourse()

    private fun insertAllData() {
        viewModelScope.launch { repository.insertAllData() }
    }
}

class DatabaseRelationViewModelFactory(private val repository: StudentRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DatabaseRelationViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DatabaseRelationViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}