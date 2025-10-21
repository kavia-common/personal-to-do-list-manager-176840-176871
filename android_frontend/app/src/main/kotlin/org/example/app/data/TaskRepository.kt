package org.example.app.data

import kotlinx.coroutines.flow.Flow

class TaskRepository(private val dao: TaskDao) {

    fun observeAll(): Flow<List<Task>> = dao.observeAll()

    suspend fun add(title: String) {
        if (title.isBlank()) return
        dao.insert(Task(title = title.trim()))
    }

    suspend fun updateTitle(id: Long, title: String) {
        if (title.isBlank()) return
        val now = System.currentTimeMillis()
        dao.update(Task(id = id, title = title.trim(), updatedAt = now))
    }

    suspend fun delete(task: Task) = dao.delete(task)

    suspend fun toggleCompleted(task: Task) {
        dao.setCompleted(task.id, !task.completed)
    }
}
