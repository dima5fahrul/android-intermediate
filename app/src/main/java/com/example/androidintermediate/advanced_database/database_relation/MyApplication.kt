package com.example.androidintermediate.advanced_database.database_relation

import android.app.Application
import com.example.androidintermediate.advanced_database.database_relation.database.StudentDatabase

class MyApplication : Application() {
    val database by lazy { StudentDatabase.getDatabase(this) }
    val repository by lazy { StudentRepository(database.studentDao()) }
}