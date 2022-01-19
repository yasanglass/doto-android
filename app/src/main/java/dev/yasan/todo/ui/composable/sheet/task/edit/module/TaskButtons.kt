package dev.yasan.todo.ui.composable.sheet.task.edit.module

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredWidth
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

@Preview
@Composable
fun TaskButtons(onCancel: () -> Unit = {}, onDone: () -> Unit = {}) {

    Row(
        modifier = Modifier
            .background(color = colorResource(id = R.color.layer_foreground))
    ) {

        Button(
            onClick = {
                onCancel()
            },
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.layer_foreground),
                contentColor = colorResource(id = R.color.text_title)
            ),
            border = BorderStroke(width = dimenDivider, color = colorResource(id = R.color.divider)),
            elevation = ButtonDefaults.elevation(
                defaultElevation = dimenElevation,
                pressedElevation = dimenElevationPressed
            )
        ) {
            Text(
                text = stringResource(R.string.cancel).uppercase(),
                fontFamily = rubikFamily,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.requiredWidth(grid()))

        Button(
            onClick = {
                onDone()
            },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = themeAccent,
                contentColor = onThemeAccent
            ),
            border = BorderStroke(
                width = dimenDivider,
                color = colorResource(id = R.color.divider)
            ),
            elevation = ButtonDefaults.elevation(
                defaultElevation = dimenElevation,
                pressedElevation = dimenElevationPressed
            ),
        ) {
            Text(
                text = stringResource(R.string.add_task).uppercase(),
                fontFamily = rubikFamily,
                fontWeight = FontWeight.Bold
            )
        }

    }

}
