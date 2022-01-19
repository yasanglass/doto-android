package dev.yasan.todo.ui.composable.screen.home.modules

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import dev.yasan.todo.data.db.entity.Task

@Composable
fun ColumnScope.HomeContent(tasks: State<List<Task>?>) {

    LazyColumn(modifier = Modifier.weight(1f)) {

        items(tasks.value ?: ArrayList()) { task ->
            TaskItem(task = task)
        }

    }

}