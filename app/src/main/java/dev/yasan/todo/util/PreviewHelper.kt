package dev.yasan.todo.util

import dev.yasan.todo.data.db.entity.Task

/**
 * Provides dummy data to composable previews. All dummy variables for previews must be created here so they can be reused.
 */
object PreviewHelper {

    val tasks = sequenceOf(
        Task( title = "Study", description = null, creationDateMillis = 1642616205350),
        Task(
            title = "Dance",
            description = "Dance to music",
            creationDateMillis = 1642615205350
        ),
        Task(
            title = "Workout",
            description = "Go running!",
            creationDateMillis = 1642517205350
        ),
        Task(
            title = "Read",
            description = "Habena de superbus axona, acquirere messor! Lixas assimilant in aboa! A falsis, calceus secundus quadra.",
            creationDateMillis = 1642616205350
        ),
        Task(
            title = "Play basketball",
            description = null,
            creationDateMillis = 1642614205350
        )
    )

}