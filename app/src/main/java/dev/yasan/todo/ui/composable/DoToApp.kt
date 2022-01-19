package dev.yasan.todo.ui.composable

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.res.colorResource
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import dev.yasan.todo.R
import dev.yasan.todo.ui.navigation.NavGraph
import dev.yasan.todo.ui.theme.DoToTheme

/**
 * Top level Composable function of DoTo.
 */
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@ExperimentalMaterialNavigationApi
@Composable
fun DoToApp() {
    DoToTheme {
        Surface(color = colorResource(id = R.color.layer_midground)) {
            NavGraph()
        }
    }
}