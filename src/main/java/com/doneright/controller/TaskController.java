package com.doneright.controller;

import com.doneright.entity.Task;
import com.doneright.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public ResponseEntity<List<Task>> getAllTasks(){
		List<Task> tasks = taskService.getAllTasks();
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable Long id){
		return taskService.getTaskById(id)
			            .map((task) -> new ResponseEntity<>(task,  HttpStatus.OK))
			            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<Task> createTask(@RequestBody Task task){
		Task createdTask = taskService.createTask(task);
		return new ResponseEntity<>(task, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
		return taskService.updateTask(id,task)
			       .map((updatedTask) -> new ResponseEntity<>(updatedTask, HttpStatus.OK))
			       .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id){
		if(taskService.deleteTask(id)){
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
