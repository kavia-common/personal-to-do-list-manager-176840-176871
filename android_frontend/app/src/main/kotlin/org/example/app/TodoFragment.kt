package org.example.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.example.app.data.AppDatabase
import org.example.app.data.Task
import org.example.app.data.TaskRepository
import org.example.app.ui.TaskFilter
import org.example.app.ui.TaskViewModel

class TodoFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels {
        val db = AppDatabase.getInstance(requireContext().applicationContext)
        val repo = TaskRepository(db.taskDao())
        TaskViewModel.provideFactory(repo)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val input = view.findViewById<EditText>(R.id.inputTask)
        val btnAdd = view.findViewById<Button>(R.id.btnAdd)
        val recycler = view.findViewById<RecyclerView>(R.id.recyclerTasks)
        val filterAll = view.findViewById<Button>(R.id.filterAll)
        val filterActive = view.findViewById<Button>(R.id.filterActive)
        val filterCompleted = view.findViewById<Button>(R.id.filterCompleted)

        val adapter = TaskAdapter(
            onToggle = { viewModel.toggleTask(it) },
            onDelete = { viewModel.deleteTask(it) },
            onConfirmEdit = { t, newTitle -> viewModel.updateTaskTitle(t, newTitle) }
        )

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        btnAdd.setOnClickListener {
            viewModel.onInputChange(input.text.toString())
            viewModel.addTask()
        }

        filterAll.setOnClickListener { viewModel.setFilter(TaskFilter.ALL) }
        filterActive.setOnClickListener { viewModel.setFilter(TaskFilter.ACTIVE) }
        filterCompleted.setOnClickListener { viewModel.setFilter(TaskFilter.COMPLETED) }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                // Apply input hint text and clear field when input becomes empty
                if (input.text.toString() != state.input) {
                    input.setText(state.input)
                    input.setSelection(state.input.length)
                }
                adapter.submitList(state.tasks)
            }
        }
    }

    private class TaskAdapter(
        val onToggle: (Task) -> Unit,
        val onDelete: (Task) -> Unit,
        val onConfirmEdit: (Task, String) -> Unit
    ) : ListAdapter<Task, TaskViewHolder>(DIFF) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
            return TaskViewHolder(view, onToggle, onDelete, onConfirmEdit)
        }

        override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
            holder.bind(getItem(position))
        }

        companion object {
            val DIFF = object : DiffUtil.ItemCallback<Task>() {
                override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean = oldItem.id == newItem.id
                override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean = oldItem == newItem
            }
        }
    }

    private class TaskViewHolder(
        itemView: View,
        val onToggle: (Task) -> Unit,
        val onDelete: (Task) -> Unit,
        val onConfirmEdit: (Task, String) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        private val check = itemView.findViewById<CheckBox>(R.id.checkComplete)
        private val title = itemView.findViewById<TextView>(R.id.textTitle)
        private val btnEdit = itemView.findViewById<Button>(R.id.btnEdit)
        private val btnDelete = itemView.findViewById<Button>(R.id.btnDelete)
        private val editRow = itemView.findViewById<View>(R.id.editRow)
        private val editTitle = itemView.findViewById<EditText>(R.id.editTitle)
        private val btnSave = itemView.findViewById<Button>(R.id.btnSave)
        private val btnCancel = itemView.findViewById<Button>(R.id.btnCancel)

        private var currentTask: Task? = null

        fun bind(task: Task) {
            currentTask = task
            title.text = task.title
            check.isChecked = task.completed
            title.paint.isStrikeThruText = task.completed
            editRow.visibility = View.GONE

            check.setOnCheckedChangeListener(null)
            check.setOnCheckedChangeListener { _, _ -> currentTask?.let(onToggle) }

            btnEdit.setOnClickListener {
                editTitle.setText(task.title)
                editRow.visibility = View.VISIBLE
            }
            btnDelete.setOnClickListener { currentTask?.let(onDelete) }
            btnSave.setOnClickListener {
                currentTask?.let { t -> onConfirmEdit(t, editTitle.text.toString()) }
                editRow.visibility = View.GONE
            }
            btnCancel.setOnClickListener { editRow.visibility = View.GONE }
        }
    }
}
