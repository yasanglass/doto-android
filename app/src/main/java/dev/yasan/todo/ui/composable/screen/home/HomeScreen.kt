package dev.yasan.todo.ui.composable.screen.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import dev.yasan.todo.ui.composable.screen.home.modules.TaskItem

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {

    val tasks = homeViewModel.getAllTasks().observeAsState()

    LazyColumn(modifier = Modifier.fillMaxWidth()) {

        items(tasks.value ?: ArrayList()) { task ->
            TaskItem(task = task)
        }

    }

}