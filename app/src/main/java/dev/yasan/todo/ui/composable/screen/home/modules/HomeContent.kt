package dev.yasan.todo.ui.composable.screen.home.modules

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.sharp.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.yasan.todo.R
import dev.yasan.todo.data.db.entity.Task
import dev.yasan.todo.ui.theme.DoToIcons
import dev.yasan.todo.ui.theme.grid
import dev.yasan.todo.ui.theme.rubikFamily

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun ColumnScope.HomeContent(
    tasks: State<List<Task>?>,
    onOpenTask: (Task) -> Unit,
    onDeleteTask: (Task) -> Unit
) {

    LazyColumn(
        modifier = Modifier.weight(1f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            AnimatedVisibility(visible = tasks.value?.isEmpty() ?: false) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(grid(6)),
                    text = stringResource(R.string.no_tasks_available),
                    fontFamily = rubikFamily,
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Italic,
                    color = colorResource(id = R.color.text_desc),
                    textAlign = TextAlign.Center
                )
            }
        }

        items(items = tasks.value ?: ArrayList(), key = { task: Task -> task.id }) { task ->

            val dismissState = rememberDismissState(
                confirmStateChange = {
                    val done =
                        it == DismissValue.DismissedToEnd || it == DismissValue.DismissedToStart
                    if (done) {
                        onDeleteTask(task)
                    }
                    done
                }
            )

            SwipeToDismiss(
                state = dismissState,
                background = {

                    val direction = dismissState.dismissDirection ?: return@SwipeToDismiss
                    val color by animateColorAsState(
                        when (dismissState.targetValue) {
                            DismissValue.Default -> colorResource(id = R.color.layer_background)
                            DismissValue.DismissedToEnd -> Color.Red
                            DismissValue.DismissedToStart -> Color.Red
                        }
                    )
                    val alignment = when (direction) {
                        DismissDirection.StartToEnd -> Alignment.CenterStart
                        DismissDirection.EndToStart -> Alignment.CenterEnd
                    }

                    Box(
                        Modifier
                            .fillMaxSize()
                            .background(color)
                            .padding(horizontal = 20.dp),
                        contentAlignment = alignment
                    ) {
                        Icon(
                            imageVector = DoToIcons.Delete,
                            contentDescription = stringResource(id = R.string.delete),
                            tint = colorResource(id = R.color.text_title)
                        )
                    }
                },
            ) {
                TaskItem(task = task) {
                    onOpenTask(task)
                }
            }

        }

        item {
            Spacer(modifier = Modifier.requiredHeight(grid(8)))
        }

    }

}