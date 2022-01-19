package dev.yasan.todo.ui.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import dev.yasan.todo.data.db.entity.Task
import dev.yasan.todo.util.PreviewHelper

/**
 * Provides preview parameters for [List]<[Task]>.
 */
class TaskListPreviewProvider : PreviewParameterProvider<List<Task>> {

    override val values = sequenceOf(PreviewHelper.tasks.toList())

}