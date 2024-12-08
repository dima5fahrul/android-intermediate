package com.example.androidintermediate.advanced_database.database_relation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.switchMap
import androidx.paging.PagedList
import com.example.androidintermediate.advanced_database.database_relation.database.Student
import com.example.androidintermediate.advanced_database.database_relation.database.StudentAndUniversity
import com.example.androidintermediate.advanced_database.database_relation.database.StudentWithCourse
import com.example.androidintermediate.advanced_database.database_relation.database.UniversityAndStudent
import com.example.androidintermediate.advanced_database.database_relation.helper.SortType

class DatabaseRelationViewModel(private val repository: StudentRepository) : ViewModel() {
    private val _sort = MutableLiveData<SortType>()

    init {
        _sort.value = SortType.ASCENDING
    }

    fun changeSortType(sortType: SortType) {
        _sort.value = sortType
    }

    fun getAllStudent(): LiveData<PagedList<Student>> = _sort.switchMap {
        repository.getAllStudent(it)
    }

    fun getAllStudentAndUniversity():
            LiveData<List<StudentAndUniversity>> = repository.getAllStudentAndUniversity()

    fun getAllUniversityAndStudent(): LiveData<List<UniversityAndStudent>> =
        repository.getAllUniversityAndStudent()

    fun getAllStudentWithCourse(): LiveData<List<StudentWithCourse>> =
        repository.getAllStudentWithCourse()
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