package dev.yasan.todo.ui.composable.sheet.task.view

import android.content.res.Configuration
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import dev.yasan.todo.R
import dev.yasan.todo.data.db.entity.Task
import dev.yasan.todo.ui.preview.TaskPreviewProvider
import dev.yasan.todo.ui.theme.dimenDivider
import dev.yasan.todo.ui.theme.grid
import dev.yasan.todo.ui.theme.rubikFamily
import dev.yasan.todo.util.Resource

@ExperimentalAnimationApi
@Composable
fun TaskViewScreen(
    taskViewViewModel: TaskViewViewModel,
    taskId: Long,
    fontFamily: FontFamily = rubikFamily
) {

    val taskResource = taskViewViewModel.task.observeAsState()

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        when (taskResource.value) {
            is Resource.Initial -> {
                taskViewViewModel.loadTask(taskId = taskId)
            }
            is Resource.Loading -> {
                androidx.compose.animation.AnimatedVisibility(visible = true) {
                    LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
                }
            }
            is Resource.Error -> {
                val errorResId =
                    taskResource.value?.messageResourceId ?: R.string.no_tasks_available
                Text(
                    modifier = Modifier.padding(grid(2)),
                    text = stringResource(id = errorResId),
                    fontFamily = fontFamily,
                    color = colorResource(id = R.color.text_title),
                )
            }
            is Resource.Success -> {
                val task = taskResource.value!!.data!!
                Column(
                    modifier = Modifier
                        .padding(grid(2))
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                ) {
                    Text(
                        text = task.title,
                        fontFamily = fontFamily,
                        color = colorResource(id = R.color.text_title),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.requiredHeight(grid()))
                    task.description?.let { description ->
                        if (description.isNotBlank()) {
                            Text(
                                text = description,
                                fontFamily = fontFamily,
                                color = colorResource(id = R.color.text_desc),
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp
                            )
                            Spacer(modifier = Modifier.requiredHeight(grid()))
                        }
                    }
                    Text(
                        text = stringResource(id = R.string.created_on, task.creationDatString),
                        color = colorResource(id = R.color.text_desc),
                        fontFamily = fontFamily,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
        }
    }

}

@Preview(
    name = "Task View Screen (Loaded)",
    group = "Light",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Task View Screen (Loaded)",
    group = "Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun TaskViewScreenLoaded(
    @PreviewParameter(TaskPreviewProvider::class) task: Task,
    fontFamily: FontFamily = rubikFamily
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.layer_foreground))
    ) {
        Column(modifier = Modifier.padding(horizontal = grid(2), vertical = grid(1.5f))) {
            Text(
                text = task.title,
                color = colorResource(id = R.color.text_title),
                fontFamily = fontFamily,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.requiredHeight(grid()))
            task.description?.let { description ->
                Text(
                    text = description, color = colorResource(id = R.color.text_desc),
                    fontFamily = fontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.requiredHeight(grid()))
            }
            Text(
                text = stringResource(id = R.string.created_on, task.creationDatString),
                color = colorResource(id = R.color.text_desc),
                fontFamily = fontFamily,
                fontSize = 10.sp,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            )
        }
        Divider(color = colorResource(id = R.color.divider), thickness = dimenDivider)
    }

}