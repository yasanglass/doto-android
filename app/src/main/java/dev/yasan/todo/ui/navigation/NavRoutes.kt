package dev.yasan.todo.ui.navigation

import dev.yasan.todo.ui.composable.screen.home.HomeScreen
import dev.yasan.todo.ui.composable.sheet.task.edit.TaskCreationScreen

/**
 * Handles all the navigation routes used on [NavGraph].
 */
object NavRoutes {

    // Home

    private const val ROUTE_HOME = "home"

    /**
     * @return Navigation route for [HomeScreen].
     */
    fun routeHome() = ROUTE_HOME

    // Task

    const val PARAM_TASK_ID = "task.id"

    // Create Task

    private const val ROUTE_TASK_CREATE = "task.create"

    /**
     * @return Navigation route for [TaskCreationScreen].
     */
    fun routeTaskCreate() = ROUTE_TASK_CREATE

}
