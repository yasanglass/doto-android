package dev.yasan.todo.data.repo

import androidx.lifecycle.LiveData
import dev.yasan.todo.data.db.entity.Task

interface TaskRepository {

    fun getAllTasks(): LiveData<List<Task>>

    suspend fun getTaskById(taskId: Long): Task?

    suspend fun insertTask(task: Task)

    suspend fun updateTask(task: Task)

    suspend fun deleteTask(task: Task)

    suspend fun deleteAllTasks()

}