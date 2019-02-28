package diat.diatapp.com.kotlin.presenter

import diat.diatapp.com.kotlin.model.Task
import java.util.*

/**
 * Created by Eric on 2/9/2019.
 */
interface TaskListContract {

    interface Presenter {
        fun attachView(view: TaskListContract.View)

        fun addNewTask(task: Task)

        fun getAllTasks()
    }

    interface View {
        fun onTasksLoaded(tasks: LinkedList<Task>)

        fun onNewTaskAdded(task: Task)
    }
}