package dev.yasan.todo.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.yasan.todo.R
import dev.yasan.todo.ui.composable.screen.home.HomeScreen
import dev.yasan.todo.ui.composable.screen.home.HomeViewModel
import dev.yasan.todo.ui.composable.sheet.task.edit.TaskCreationScreen
import dev.yasan.todo.ui.composable.sheet.task.edit.TaskCreationViewModel
import dev.yasan.todo.ui.composable.sheet.task.view.TaskViewScreen
import dev.yasan.todo.ui.composable.sheet.task.view.TaskViewViewModel
import dev.yasan.todo.ui.theme.themePrimaryDark

/**
 * The main navigation graph for DoTo.
 *
 * @param startDestination The destination route that the app starts with.
 *
 * @see NavRoutes
 */
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun NavGraph(
    startDestination: String = NavRoutes.routeHome()
) {

    val navController = rememberAnimatedNavController()

    val systemUiController = rememberSystemUiController().apply {
        setNavigationBarColor(color = colorResource(id = R.color.layer_background))
    }

    AnimatedNavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = { _, _ ->
            fadeIn()
        },
        popEnterTransition = { _, _ ->
            fadeIn()
        },
        exitTransition = { _, _ ->
            fadeOut()
        },
        popExitTransition = { _, _ ->
            fadeOut()
        },
    ) {

        composable(route = NavRoutes.routeHome()) {

            systemUiController.setStatusBarColor(color = themePrimaryDark)

            val homeViewModel: HomeViewModel = hiltViewModel(it)

            HomeScreen(homeViewModel = homeViewModel, navController = navController)

        }

        composable(route = NavRoutes.routeTaskCreate()) {

            systemUiController.setStatusBarColor(color = colorResource(id = R.color.layer_midground))

            val taskCreationViewModel: TaskCreationViewModel = hiltViewModel(it)

            TaskCreationScreen(
                taskCreationViewModel = taskCreationViewModel,
                navController = navController,
            )

        }

        composable(
            route = NavRoutes.routeTaskViewBase,
            arguments = listOf(
                navArgument(NavRoutes.PARAM_TASK_ID) {
                    type = NavType.LongType
                },
            )
        ) {

            systemUiController.setStatusBarColor(color = colorResource(id = R.color.layer_midground))

            val taskId = it.arguments?.getLong(NavRoutes.PARAM_TASK_ID) ?: 0L

            val taskViewViewModel: TaskViewViewModel = hiltViewModel(it)

            TaskViewScreen(taskViewViewModel = taskViewViewModel, taskId = taskId)

        }

    }

}
