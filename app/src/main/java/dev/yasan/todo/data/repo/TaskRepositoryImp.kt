package dev.yasan.todo.data.repo

import androidx.lifecycle.LiveData
import dev.yasan.todo.data.db.dao.TaskDao
import dev.yasan.todo.data.db.entity.Task

class TaskRepositoryImp constructor(private val taskDao: TaskDao) : TaskRepository {

    override fun getAllTasks(): LiveData<List<Task>> {
        return taskDao.getAll()
    }

    override suspend fun getTaskById(taskId: Long): Task? {
        return taskDao.getById(taskId = taskId)
    }

    override suspend fun insertTask(task: Task) {
        taskDao.insert(task = task)
    }

    override suspend fun updateTask(task: Task) {
        taskDao.update(task = task)
    }

    override suspend fun deleteTask(task: Task) {
        taskDao.delete(task = task)
    }

    override suspend fun deleteAllTasks() {
        taskDao.deleteAll()
    }

}