package dev.yasan.todo.ui.composable.sheet.task.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yasan.todo.R
import dev.yasan.todo.data.db.entity.Task
import dev.yasan.todo.data.repo.TaskRepository
import dev.yasan.todo.util.DispatcherProvider
import dev.yasan.todo.util.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider,
    private val taskRepository: TaskRepository
) : ViewModel() {

    private var _task = MutableLiveData<Resource<Task>>(Resource.Initial())
    val task: LiveData<Resource<Task>> get() = _task

    fun loadTask(taskId: Long) {
        viewModelScope.launch(dispatchers.io) {
            Log.d("TAG", "loadTask: ")
            _task.postValue(Resource.Loading())
            val mTask = taskRepository.getTaskById(taskId = taskId)
            if (mTask != null) {
                _task.postValue(Resource.Success(data = mTask))
            } else {
                _task.postValue(Resource.Error(messageResourceId = R.string.task_not_found))
            }
        }
    }

}