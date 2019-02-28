package diat.diatapp.com.kotlin

import android.support.v4.app.Fragment
import android.os.Bundle

import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import diat.diatapp.com.kotlin.adapter.TaskListAdapter
import diat.diatapp.com.kotlin.model.Task
import diat.diatapp.com.kotlin.presenter.TaskListContract
import diat.diatapp.com.kotlin.presenter.TaskListPresenter
import kotlinx.android.synthetic.main.fragment_task_list.*

class TaskListFragment : Fragment(), TaskListContract.View {

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

    private fun setupRecyclerView(tasks: List<Task>) {
        task_list_recycler_view.layoutManager = LinearLayoutManager(context)

        taskListAdapter = TaskListAdapter(context, tasks)
        task_list_recycler_view.adapter = taskListAdapter
    }

    override fun onTasksLoaded(tasks: List<Task>) {
        this.tasks = tasks
        setupRecyclerView(tasks)
    }
}
