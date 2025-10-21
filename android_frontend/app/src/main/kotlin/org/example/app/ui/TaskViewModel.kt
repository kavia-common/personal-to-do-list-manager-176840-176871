package org.example.app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.example.app.data.Task
import org.example.app.data.TaskRepository

enum class TaskFilter { ALL, ACTIVE, COMPLETED }

data class UiState(
    val tasks: List<Task> = emptyList(),
    val filter: TaskFilter = TaskFilter.ALL,
    val input: String = ""
)

// PUBLIC_INTERFACE
class TaskViewModel(private val repo: TaskRepository) : ViewModel() {

    /** Exposes the filtered list of tasks, current filter, and input text as a StateFlow for the UI. */
    val state: StateFlow<UiState>

    private val filter = MutableStateFlow(TaskFilter.ALL)
    private val input = MutableStateFlow("")

    init {
        state = combine(repo.observeAll(), filter, input) { tasks, f, text ->
            UiState(
                tasks = when (f) {
                    TaskFilter.ALL -> tasks
                    TaskFilter.ACTIVE -> tasks.filter { !it.completed }
                    TaskFilter.COMPLETED -> tasks.filter { it.completed }
                },
                filter = f,
                input = text
            )
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), UiState())
    }

    // PUBLIC_INTERFACE
    fun setFilter(newFilter: TaskFilter) {
        /** Set the current filter for task visibility. */
        filter.value = newFilter
    }

    // PUBLIC_INTERFACE
    fun onInputChange(value: String) {
        /** Update the current text input for adding a new task. */
        input.value = value
    }

    // PUBLIC_INTERFACE
    fun addTask() {
        /** Add a new task using the current input text, then clear input. */
        val title = input.value
        viewModelScope.launch {
            repo.add(title)
            input.value = ""
        }
    }

    // PUBLIC_INTERFACE
    fun deleteTask(task: Task) {
        /** Delete the specified task. */
        viewModelScope.launch { repo.delete(task) }
    }

    // PUBLIC_INTERFACE
    fun toggleTask(task: Task) {
        /** Toggle completion of the specified task. */
        viewModelScope.launch { repo.toggleCompleted(task) }
    }

    // PUBLIC_INTERFACE
    fun updateTaskTitle(task: Task, newTitle: String) {
        /** Update the title of the specified task. */
        viewModelScope.launch { repo.updateTitle(task.id, newTitle) }
    }

    companion object {
        // PUBLIC_INTERFACE
        fun provideFactory(repo: TaskRepository): ViewModelProvider.Factory {
            /** Factory to construct TaskViewModel with required repository. */
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    @Suppress("UNCHECKED_CAST")
                    return TaskViewModel(repo) as T
                }
            }
        }
    }
}
