package com.example.androidintermediate.advanced_database.database_relation

import androidx.lifecycle.LiveData
import com.example.androidintermediate.advanced_database.database_relation.database.Student
import com.example.androidintermediate.advanced_database.database_relation.database.StudentAndUniversity
import com.example.androidintermediate.advanced_database.database_relation.database.StudentDao
import com.example.androidintermediate.advanced_database.database_relation.database.StudentWithCourse
import com.example.androidintermediate.advanced_database.database_relation.database.UniversityAndStudent

class StudentRepository(private val studentDao: StudentDao) {
    fun getAllStudent(): LiveData<List<Student>> = studentDao.getAllStudent()
    fun getAllStudentAndUniversity(): LiveData<List<StudentAndUniversity>> =
        studentDao.getAllStudentAndUniversity()

    fun getAllUniversityAndStudent(): LiveData<List<UniversityAndStudent>> =
        studentDao.getAllUniversityAndStudent()

    fun getAllStudentWithCourse(): LiveData<List<StudentWithCourse>> =
        studentDao.getAllStudentWithCourse()

}