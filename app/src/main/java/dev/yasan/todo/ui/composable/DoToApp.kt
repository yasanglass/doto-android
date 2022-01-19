package dev.yasan.todo.ui.composable

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import dev.yasan.todo.ui.navigation.NavGraph
import dev.yasan.todo.ui.theme.DoToTheme

/**
 * Top level Composable function of DoTo.
 */
@ExperimentalAnimationApi
@ExperimentalMaterialNavigationApi
@Composable
fun DoToApp() {
    DoToTheme {
        Surface {
            NavGraph()
        }
    }
}