package dev.yasan.todo.ui.composable.screen.home.modules

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import dev.yasan.todo.R
import dev.yasan.todo.ui.theme.*

@Preview(name = "Add Task Button", "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(name = "Add Task Button", "Light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun AddTaskButton(onClick: () -> Unit = {}) {

    Column(modifier = Modifier.background(color = colorResource(id = R.color.layer_foreground))) {

        Button(
            onClick = {
                onClick()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = grid(2), vertical = grid(1.5f)),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = themeAccent,
                contentColor = onThemeAccent
            ),
            border = BorderStroke(width = dimenDivider, color = colorResource(id = R.color.divider)),
            elevation = ButtonDefaults.elevation(
                defaultElevation = dimenElevation,
                pressedElevation = dimenElevationPressed
            )
        ) {
            Text(
                text = stringResource(R.string.add_task).uppercase(),
                fontFamily = rubikFamily,
                fontWeight = FontWeight.Bold
            )
        }

    }

}