package dev.yasan.todo.ui.navigation

import dev.yasan.todo.ui.composable.screen.home.HomeScreen
import dev.yasan.todo.ui.composable.sheet.task.edit.TaskCreationScreen
import dev.yasan.todo.ui.composable.sheet.task.view.TaskViewScreen

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

    // Create Task

    private const val ROUTE_TASK_CREATE = "task.create"

    /**
     * @return Navigation route for [TaskCreationScreen].
     */
    fun routeTaskCreate() = ROUTE_TASK_CREATE

    // View Task

    const val PARAM_TASK_ID = "task.id"

    private const val ROUTE_TASK_VIEW = "task.view"

    /**
     * @return Base navigation route for [TaskViewScreen].
     */
    val routeTaskViewBase: String get() = "$ROUTE_TASK_VIEW/{$PARAM_TASK_ID}"

    /**
     * @return Navigation route for [TaskViewScreen].
     */
    fun routeTaskView(taskId: Long): String = "$ROUTE_TASK_VIEW/$taskId"

}
