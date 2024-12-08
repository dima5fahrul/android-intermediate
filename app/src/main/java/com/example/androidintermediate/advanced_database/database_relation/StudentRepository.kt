package com.example.androidintermediate.advanced_database.database_relation

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.androidintermediate.advanced_database.database_relation.database.Student
import com.example.androidintermediate.advanced_database.database_relation.database.StudentAndUniversity
import com.example.androidintermediate.advanced_database.database_relation.database.StudentDao
import com.example.androidintermediate.advanced_database.database_relation.database.StudentWithCourse
import com.example.androidintermediate.advanced_database.database_relation.database.UniversityAndStudent
import com.example.androidintermediate.advanced_database.database_relation.helper.SortType
import com.example.androidintermediate.advanced_database.database_relation.helper.SortUtils

class StudentRepository(private val studentDao: StudentDao) {
    fun getAllStudent(sortType: SortType): LiveData<PagedList<Student>> {
        val query = SortUtils.getSortedQuery(sortType)
        val student = studentDao.getAllStudent(query)

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(30)
            .setPageSize(10)
            .build()

        return LivePagedListBuilder(student, config).build()
    }

    fun getAllStudentAndUniversity(): LiveData<List<StudentAndUniversity>> =
        studentDao.getAllStudentAndUniversity()

    fun getAllUniversityAndStudent(): LiveData<List<UniversityAndStudent>> =
        studentDao.getAllUniversityAndStudent()

    fun getAllStudentWithCourse(): LiveData<List<StudentWithCourse>> =
        studentDao.getAllStudentWithCourse()

}