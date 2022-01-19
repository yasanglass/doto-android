package dev.yasan.todo.ui.composable.sheet.task.edit

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.sharp.Description
import androidx.compose.material.icons.sharp.Title
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.yasan.todo.R
import dev.yasan.todo.ui.composable.common.DoToDivider
import dev.yasan.todo.ui.composable.sheet.task.edit.module.TaskButtons
import dev.yasan.todo.ui.theme.DoToIcons
import dev.yasan.todo.ui.theme.grid
import dev.yasan.todo.ui.theme.rubikFamily

@ExperimentalComposeUiApi
@Composable
fun TaskCreationScreen(
    taskCreationViewModel: TaskCreationViewModel,
    navController: NavController,
    fontFamily: FontFamily = rubikFamily
) {

    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    val titleState = remember { mutableStateOf(TextFieldValue()) }
    val descriptionState = remember { mutableStateOf(TextFieldValue()) }

    DisposableEffect(Unit) {
        onDispose { }
    }

    Column(modifier = Modifier.padding(grid(2))) {

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = titleState.value,
            onValueChange = {
                titleState.value = it
            },
            maxLines = 1,
            singleLine = true,
            label = {
                Text(
                    text = stringResource(id = R.string.title),
                    color = colorResource(id = R.color.text_desc),
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal,
                    fontFamily = fontFamily
                )
            },
            textStyle = TextStyle(
                color = colorResource(id = R.color.text_title),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = rubikFamily
            ),
            leadingIcon = {
                Icon(
                    imageVector = DoToIcons.Title,
                    contentDescription = stringResource(id = R.string.title),
                    tint = colorResource(id = R.color.text_title)
                )
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                autoCorrect = true,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            )
        )

        Spacer(modifier = Modifier.requiredHeight(grid(2)))

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = descriptionState.value,
            onValueChange = {
                descriptionState.value = it
            },
            label = {
                Text(
                    text = stringResource(id = R.string.description),
                    color = colorResource(id = R.color.text_desc),
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal,
                    fontFamily = fontFamily
                )
            },
            maxLines = 5,
            textStyle = TextStyle(
                color = colorResource(id = R.color.text_title),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = rubikFamily
            ),
            leadingIcon = {
                Icon(
                    imageVector = DoToIcons.Description,
                    contentDescription = stringResource(id = R.string.title),
                    tint = colorResource(id = R.color.text_title)
                )
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                autoCorrect = true,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(onDone = {
                keyboardController?.hide()
            })
        )

        DoToDivider()

        Spacer(modifier = Modifier.requiredHeight(grid(2)))

        TaskButtons(
            onCancel = {
                navController.navigateUp()
            },
            onDone = {
                val title = titleState.value.text
                val description = descriptionState.value.text
                if (title.isNotBlank()) {
                    taskCreationViewModel.createTask(title = title, description = description)
                    navController.navigateUp()
                } else {
                    Toast.makeText(context, "Please enter task title first", Toast.LENGTH_SHORT)
                        .show()
                    // TODO replace with a snackBar
                }
            }
        )

    }

}