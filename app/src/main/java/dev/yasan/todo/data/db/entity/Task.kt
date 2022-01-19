package dev.yasan.todo.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat

@Entity(tableName = "todo_tasks")
data class Task(
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "creation_date") val creationDateMillis: Long = System.currentTimeMillis(),
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0

    val creationDatString: String
        get() { // TODO improve string style
            val df = SimpleDateFormat.getDateTimeInstance()
            return df.format(creationDateMillis)
        }

}