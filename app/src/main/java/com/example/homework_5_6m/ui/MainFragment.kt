package com.example.homework_5_6m.ui

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.homework_5_6m.App
import com.example.homework_5_6m.R
import com.example.homework_5_6m.model.TaskModel
import com.example.homework_5_6m.ui.adapter.TaskAdapter


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val adapter = TaskAdapter(this::onLongClickItem, this::onClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        val data = App.db.taskDao().getAll()
        adapter.submitList(data)
        binding.fab.setOnClickListener{
            findNavController().navigate(R.id.addFragment)
        }
    }
    private fun onLongClickItem(tasks:TaskModel){
        showAlertDialog(tasks)
    }

    private fun showAlertDialog(tasks: TaskModel) {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle("Удалить? " + tasks.title)
            .setMessage("Вы точно хотите удалить?")
            .setCancelable(true)
            .setPositiveButton("Да"){_,_ ->
                App.db.taskDao().delete(tasks)
                val data = App.db.taskDao().getAll()
                adapter.submitList(data)
            }
            .setNegativeButton("Нет"){_,_ -> }
            .show()
    }
    private fun onClick(task: TaskModel){
        findNavController().navigate(R.id.addFragment, bundleOf(TASK_EDIT_KEY to task))
    }

    companion object{
        const val TASK_EDIT_KEY = "task.edit.key"
    }
}