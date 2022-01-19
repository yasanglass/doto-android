package dev.yasan.todo.ui.navigation

import dev.yasan.todo.ui.composable.screen.home.HomeScreen
import dev.yasan.todo.ui.composable.sheet.task.edit.TaskEditScreen

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

    // Edit Task

    private const val ROUTE_TASK_EDIT = "task.edit"

    /**
     * @return Navigation route for [TaskEditScreen].
     */
    fun routeTaskEdit(taskId: Long = 0) = "$ROUTE_TASK_EDIT/$taskId"

    fun routeTaskBase(taskId: Long = 0) = "$ROUTE_TASK_EDIT/{$PARAM_TASK_ID}"

}
