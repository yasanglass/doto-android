package dev.yasan.todo.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.yasan.todo.data.db.DoToDatabase
import dev.yasan.todo.data.db.dao.TaskDao
import dev.yasan.todo.data.repo.TaskRepository
import dev.yasan.todo.data.repo.TaskRepositoryImp
import dev.yasan.todo.util.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Singleton
    @Provides
    fun provideDispatchers(): DispatcherProvider = object : DispatcherProvider {
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined
    }

    @Singleton
    @Provides
    fun provideDatabase(
        app: Application,
        callback: DoToDatabase.CallBack
    ) = Room.databaseBuilder(
        app,
        DoToDatabase::class.java,
        DoToDatabase.DATABASE_NAME
    ).fallbackToDestructiveMigration()
        .addCallback(callback)
        .build()

    @Provides
    fun provideTaskDAO(doToDatabase: DoToDatabase) =
        doToDatabase.taskDao()

    @Singleton
    @Provides
    fun provideTaskRepository(taskDao: TaskDao): TaskRepository =
        TaskRepositoryImp(taskDao = taskDao)

}
