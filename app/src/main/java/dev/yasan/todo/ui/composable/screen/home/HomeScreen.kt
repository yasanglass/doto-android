package dev.yasan.todo.ui.composable.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import dev.yasan.todo.ui.composable.common.DoToDivider
import dev.yasan.todo.ui.composable.screen.home.modules.AddTaskButton
import dev.yasan.todo.ui.composable.screen.home.modules.HomeContent
import dev.yasan.todo.ui.composable.screen.home.modules.HomeTitle

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {

    val tasks = homeViewModel.getAllTasks().observeAsState()

    Column(modifier = Modifier.fillMaxSize()) {

        HomeTitle()

        DoToDivider()

        HomeContent(tasks = tasks)

        DoToDivider()

        AddTaskButton()

    }

}