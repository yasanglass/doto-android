package dev.yasan.todo.util

import dev.yasan.todo.di.ApplicationModule
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * An interface used for providing Coroutines' [Dispatchers] as Singletons using Hilt.
 *
 * @see Dispatchers
 * @see ApplicationModule
 */
interface DispatcherProvider {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}
