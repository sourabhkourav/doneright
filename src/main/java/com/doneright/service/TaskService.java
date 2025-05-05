package com.doneright.service;

import com.doneright.entity.Task;
import com.doneright.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}

	public Optional<Task> getTaskById(Long id){
		return taskRepository.findById(id);
	}

	public Task createTask(Task task){
		return taskRepository.save(task);
	}

	public Optional<Task> updateTask(Long id, Task newTask){
		return taskRepository.findById(id)
			.map((task) -> {
				task.setTitle(Optional.ofNullable(newTask.getTitle()).orElseGet(task::getTitle));
				task.setCompleted(Optional.ofNullable(newTask.isCompleted()).orElseGet(task::isCompleted));
				return taskRepository.save(task);
			});
	}

	public boolean deleteTask(Long id){
		if(taskRepository.existsById(id)){
			taskRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
