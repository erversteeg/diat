package diat.diatapp.com.kotlin.presenter

import diat.diatapp.com.kotlin.model.Task
import java.util.*

/**
 * Created by Eric on 2/9/2019.
 */

class TaskListPresenter: TaskListContract.Presenter {

    private var tasks = LinkedList<Task>()

    private var view: TaskListContract.View? = null

    override fun attachView(view: TaskListContract.View) {
        this.view = view

        val task1 = Task("Fortnite YouTube Channel", "Building a Youtube channel by committing to one video upload per day.  I record my gameplay each day then commentate on it.",
                null, emptyList(), 39, null)

        tasks.add(task1)
    }

    override fun addNewTask(task: Task) {
        tasks.add(task)

        view?.onNewTaskAdded(task)
    }

    override fun getAllTasks() {
        view?.onTasksLoaded(tasks)
    }
}