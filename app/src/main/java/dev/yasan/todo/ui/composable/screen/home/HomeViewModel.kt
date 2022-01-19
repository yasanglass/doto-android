package dev.yasan.todo.ui.composable.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yasan.todo.data.db.entity.Task
import dev.yasan.todo.data.repo.TaskRepository
import dev.yasan.todo.util.DispatcherProvider
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * [ViewModel] for [HomeScreen].
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider,
    private val taskRepository: TaskRepository
) : ViewModel() {

    fun getAllTasks(): LiveData<List<Task>> = taskRepository.getAllTasks()

    fun deleteTask(task: Task) {
        viewModelScope.launch(dispatchers.io) {
            taskRepository.deleteTask(task = task)
        }
    }

}