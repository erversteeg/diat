package diat.diatapp.com.kotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import diat.diatapp.com.kotlin.R
import diat.diatapp.com.kotlin.model.Task
import kotlinx.android.synthetic.main.task_list_item.view.*

/**
 * Created by Eric on 2/8/2019.
 */

class TaskListAdapter(private val context: Context, private val taskList: List<Task>): RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TaskViewHolder {
        return TaskViewHolder(LayoutInflater.from(context).inflate(R.layout.task_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: TaskViewHolder?, position: Int) {
        holder?.titleTextView?.text = taskList[position].title
        holder?.daysCompletedTextView?.text = context.resources.getString(R.string.days_completed, taskList[position].totalDaysCompleted)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    class TaskViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val titleTextView = view.title_text_view
        val daysCompletedTextView = view.days_completed_text_view
    }
}