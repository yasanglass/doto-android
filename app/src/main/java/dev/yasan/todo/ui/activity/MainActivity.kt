package dev.yasan.todo.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import dev.yasan.todo.ui.composable.DoToApp

/**
 * The main & only activity of DoTo.
 *
 * Anything that can be put inside [DoToApp] should not be put here.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoToApp()
        }
    }

}