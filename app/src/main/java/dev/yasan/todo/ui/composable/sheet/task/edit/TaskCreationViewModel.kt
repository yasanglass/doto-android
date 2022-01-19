package dev.yasan.todo.ui.composable.sheet.task.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yasan.todo.data.db.entity.Task
import dev.yasan.todo.data.repo.TaskRepository
import dev.yasan.todo.util.DispatcherProvider
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskCreationViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider,
    private val taskRepository: TaskRepository
) : ViewModel() {

    fun createTask(title: String, description: String) {
        viewModelScope.launch(dispatchers.io) {
            val task = Task(
                title = title,
                description = description
            )
            taskRepository.insertTask(task = task)
        }
    }

}