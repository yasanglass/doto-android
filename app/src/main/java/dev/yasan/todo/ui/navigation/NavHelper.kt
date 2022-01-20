package dev.yasan.todo.ui.navigation

import androidx.navigation.NavController
import dev.yasan.todo.data.db.entity.Task

object NavHelper {

    fun createTask(navController: NavController) {
        navController.navigate(NavRoutes.routeTaskCreate())
    }

    fun openTask(navController: NavController, task: Task) {
        navController.navigate(NavRoutes.routeTaskView(taskId = task.id))
    }

}