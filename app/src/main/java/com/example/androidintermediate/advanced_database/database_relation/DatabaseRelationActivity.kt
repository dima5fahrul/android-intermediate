package com.example.androidintermediate.advanced_database.database_relation

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidintermediate.R
import com.example.androidintermediate.advanced_database.database_relation.adapter.StudentAndUniversityAdapter
import com.example.androidintermediate.advanced_database.database_relation.adapter.StudentListAdapter
import com.example.androidintermediate.advanced_database.database_relation.adapter.StudentWithCourseAdapter
import com.example.androidintermediate.advanced_database.database_relation.adapter.UniversityAndStudentAdapter
import com.example.androidintermediate.databinding.ActivityDatabaseRelationBinding

class DatabaseRelationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDatabaseRelationBinding
    private val viewModel: DatabaseRelationViewModel by viewModels {
        DatabaseRelationViewModelFactory((application as MyApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatabaseRelationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvStudent.layoutManager = LinearLayoutManager(this)

        getStudent()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_single_table -> {
                getStudent()
                return true
            }

            R.id.action_many_to_one -> {
                getStudentAndUniversity()
                true
            }

            R.id.action_one_to_many -> {
                getUniversityAndStudent()
                true
            }

            R.id.action_many_to_many -> {
                getStudentWithCourse()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getStudent() {
        val adapter = StudentListAdapter()
        binding.rvStudent.adapter = adapter
        viewModel.getAllStudent().observe(this) { adapter.submitList(it) }
    }

    private fun getStudentAndUniversity() {
        val adapter = StudentAndUniversityAdapter()
        binding.rvStudent.adapter = adapter
        viewModel.getAllStudentAndUniversity().observe(this) {
            adapter.submitList(it)
            Log.d(TAG, "getStudentAndUniversity: $it")
        }
    }

    private fun getUniversityAndStudent() {
        val adapter = UniversityAndStudentAdapter()
        binding.rvStudent.adapter = adapter
        viewModel.getAllUniversityAndStudent().observe(this) {
            Log.d(TAG, "getUniversityAndStudent: $it")
            adapter.submitList(it)
        }
    }


    private fun getStudentWithCourse() {
        val adapter = StudentWithCourseAdapter()
        binding.rvStudent.adapter = adapter
        viewModel.getAllStudentWithCourse().observe(this) {
            Log.d(TAG, "getStudentWithCourse: $it")
            adapter.submitList(it)
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}