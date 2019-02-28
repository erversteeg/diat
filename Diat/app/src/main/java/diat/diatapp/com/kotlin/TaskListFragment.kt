package diat.diatapp.com.kotlin

import android.support.v4.app.Fragment
import android.os.Bundle

import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import diat.diatapp.com.kotlin.adapter.TaskListAdapter
import diat.diatapp.com.kotlin.model.Task
import diat.diatapp.com.kotlin.presenter.TaskListContract
import diat.diatapp.com.kotlin.presenter.TaskListPresenter
import kotlinx.android.synthetic.main.fragment_task_list.*
import diat.diatapp.com.kotlin.adapter.SwipeToDeleteCallback
import android.support.v7.widget.helper.ItemTouchHelper
import java.util.*


class TaskListFragment : Fragment(), TaskListContract.View, TaskListAdapter.TaskClickListener {

    var tasks: List<Task>? = null

    lateinit var presenter: TaskListPresenter

    var taskListAdapter: TaskListAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = TaskListPresenter()
        presenter.attachView(this)

        presenter.getAllTasks()
    }

    private fun setupRecyclerView(tasks: LinkedList<Task>) {
        task_list_recycler_view.layoutManager = LinearLayoutManager(context)

        taskListAdapter = TaskListAdapter(context, tasks, this)
        task_list_recycler_view.adapter = taskListAdapter

        val itemTouchHelper = ItemTouchHelper(SwipeToDeleteCallback(taskListAdapter!!))
        itemTouchHelper.attachToRecyclerView(task_list_recycler_view)
    }

    override fun onTasksLoaded(tasks: LinkedList<Task>) {
        this.tasks = tasks
        setupRecyclerView(tasks)
    }

    override fun onNewTaskAdded(task: Task) {
        taskListAdapter?.notifyDataSetChanged()
    }

    override fun onTaskClicked(task: Task, pos: Int) {
        Toast.makeText(context, task.title + " was clicked!", Toast.LENGTH_LONG).show()
    }
}
