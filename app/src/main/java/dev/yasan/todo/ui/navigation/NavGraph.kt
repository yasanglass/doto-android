package dev.yasan.todo.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.bottomSheet
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.yasan.todo.R
import dev.yasan.todo.ui.composable.screen.home.HomeScreen
import dev.yasan.todo.ui.composable.screen.home.HomeViewModel
import dev.yasan.todo.ui.composable.sheet.task.edit.TaskEditScreen
import dev.yasan.todo.ui.composable.sheet.task.edit.TaskEditViewModel
import dev.yasan.todo.ui.theme.themePrimaryDark

/**
 * The main navigation graph for DoTo.
 *
 * @param startDestination The destination route that the app starts with.
 *
 * @see NavRoutes
 */
@ExperimentalMaterialNavigationApi
@ExperimentalAnimationApi
@Composable
fun NavGraph(
    startDestination: String = NavRoutes.routeHome()
) {

    val bottomSheetNavigator = rememberBottomSheetNavigator()
    val navController = rememberAnimatedNavController(bottomSheetNavigator)

    // Update system bar colors
    rememberSystemUiController().apply {
        setStatusBarColor(color = themePrimaryDark)
        setNavigationBarColor(color = colorResource(id = R.color.layer_background))
    }

    ModalBottomSheetLayout(bottomSheetNavigator) {
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

                val homeViewModel: HomeViewModel = hiltViewModel(it)

                HomeScreen(homeViewModel = homeViewModel, navController = navController)

            }

            bottomSheet(
                route = NavRoutes.routeTaskBase(),
                arguments = listOf(
                    navArgument(NavRoutes.PARAM_TASK_ID) {
                        type = NavType.LongType
                    }
                )
            ) {

                val taskId: Long? = it.arguments?.getLong(NavRoutes.PARAM_TASK_ID)

                val taskEditViewModel: TaskEditViewModel = hiltViewModel(it)

                TaskEditScreen(
                    taskEditViewModel = taskEditViewModel,
                    navController = navController,
                    taskId = taskId
                )

            }

        }
    }

}
