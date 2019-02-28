package diat.diatapp.com.kotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class AddTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_task)
    }

    companion object {
        fun buildAddTaskIntent(context: Context): Intent {
            return Intent(context, AddTaskActivity::class.java)
        }
    }
}