package dev.yasan.todo.ui.navigation

import androidx.navigation.NavController

object NavHelper {

    fun createTask(navController: NavController) {
        navController.navigate(NavRoutes.routeTaskCreate())
    }

}