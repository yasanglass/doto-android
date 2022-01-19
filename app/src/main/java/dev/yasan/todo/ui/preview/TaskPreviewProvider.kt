package dev.yasan.todo.ui.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.yasan.todo.data.db.entity.Task
import dev.yasan.todo.util.PreviewHelper

/**
 * Provides preview parameters for [Task].
 */
class TaskPreviewProvider : PreviewParameterProvider<Task> {

    override val values = PreviewHelper.tasks

}