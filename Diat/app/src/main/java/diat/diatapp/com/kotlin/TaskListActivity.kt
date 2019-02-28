package diat.diatapp.com.kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import diat.diatapp.com.kotlin.model.Task

import kotlinx.android.synthetic.main.activity_task_list.*
import kotlinx.android.synthetic.main.content_list.*
import java.util.*

class TaskListActivity : AppCompatActivity() {

    private val addNewTaskRequestCode = 100



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_task_list)
        setSupportActionBar(toolbar)

        fab_add_new_task.setOnClickListener {
            val newTaskIntent = AddTaskActivity.buildAddTaskIntent(this)
            startActivityForResult(newTaskIntent, addNewTaskRequestCode)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_list, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == addNewTaskRequestCode) {
            if (resultCode == Activity.RESULT_OK) {
                (fragment as TaskListFragment).presenter.addNewTask(Task(data?.getStringExtra("name")!!, "", null, LinkedList<Date>(), data.getIntExtra("days_completed_so_far", 0), null))
            }
        }
    }
}
