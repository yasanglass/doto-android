package dev.yasan.todo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.yasan.todo.data.db.dao.TaskDao
import dev.yasan.todo.data.db.entity.Task
import javax.inject.Inject

@Database(
    entities = [Task::class],
    version = 1,
)
abstract class DoToDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "doto"
        const val DATABASE_FILE_NAME = "$DATABASE_NAME.db"
    }

    abstract fun taskDao(): TaskDao

    class CallBack @Inject constructor() : RoomDatabase.Callback()

}
