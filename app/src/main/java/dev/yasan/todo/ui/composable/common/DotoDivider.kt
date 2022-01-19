package dev.yasan.todo.ui.composable.common

import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import dev.yasan.todo.R
import dev.yasan.todo.ui.theme.dimenDivider

@Composable
fun DoToDivider(){
    Divider(
        color = colorResource(id = R.color.divider),
        thickness = dimenDivider
    )
}