package diat.diatapp.com.kotlin.presenter

import diat.diatapp.com.kotlin.model.Task

/**
 * Created by Eric on 2/9/2019.
 */
interface TaskListContract {

    interface Presenter {
        fun attachView(view: TaskListContract.View)

        fun getAllTasks()
    }

    interface View {
        fun onTasksLoaded(tasks: List<Task>)
    }
}