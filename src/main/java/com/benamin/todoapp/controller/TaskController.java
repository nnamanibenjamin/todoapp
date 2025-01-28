package com.benamin.todoapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.benamin.todoapp.model.Task;
import com.benamin.todoapp.services.TaskServices;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    final TaskServices taskServices;

    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    @GetMapping
    public String getTask(Model model){
        List <Task> tasks = taskServices.getAllTasks(); 
        model.addAttribute("tasks", tasks);
        return "tasks"; 
    }

    @PostMapping 
    public String createTask(@RequestParam String title) {
        taskServices.createTask(title);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask( @PathVariable Long id) {
      taskServices.toggleTask(id);
      return "redirect:/tasks";
    }
    @GetMapping("/{id}/delete")
    public String deleteTask( @PathVariable Long id) {
      taskServices.deleteTask(id);
      return "redirect:/tasks";
    }

}
