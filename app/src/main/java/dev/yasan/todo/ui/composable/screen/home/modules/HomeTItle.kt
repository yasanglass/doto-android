package dev.yasan.todo.ui.composable.screen.home.modules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import dev.yasan.todo.R
import dev.yasan.todo.ui.theme.grid
import dev.yasan.todo.ui.theme.onThemePrimary
import dev.yasan.todo.ui.theme.rubikFamily
import dev.yasan.todo.ui.theme.themePrimary

@Preview
@Composable
fun HomeTitle(modifier: Modifier = Modifier) {

    Text(
        modifier = Modifier
            .background(color = themePrimary)
            .fillMaxWidth()
            .padding(grid(2)),
        text = stringResource(id = R.string.app_name),
        color = onThemePrimary,
        fontFamily = rubikFamily,
        fontWeight = FontWeight.Black
    )

}