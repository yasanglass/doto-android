package dev.yasan.todo.ui.composable.sheet.task.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yasan.todo.data.db.entity.Task
import dev.yasan.todo.data.repo.TaskRepository
import javax.inject.Inject

@HiltViewModel
class TaskEditViewModel @Inject constructor(private val taskRepository: TaskRepository) : ViewModel() {

    fun getAllTasks(): LiveData<List<Task>> = taskRepository.getAllTasks()

}