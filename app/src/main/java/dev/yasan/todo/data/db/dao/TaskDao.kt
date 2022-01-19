package dev.yasan.todo.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import dev.yasan.todo.data.db.DoToDatabase
import dev.yasan.todo.data.db.entity.Task

/**
 * Data access object for [Task].
 *
 * @see [DoToDatabase]
 */
@Dao
interface TaskDao {

    @Query("SELECT * FROM todo_tasks ORDER BY creation_date")
    fun getAll(): LiveData<List<Task>>

    @Query("SELECT * FROM todo_tasks WHERE id=:taskId")
    suspend fun getById(taskId: Long): Task?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("DELETE FROM todo_tasks")
    suspend fun deleteAll()

}
