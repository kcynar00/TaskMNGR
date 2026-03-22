package com.taskmngr.release.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taskmngr.release.model.Task;
import com.taskmngr.release.repository.TaskRepository;

@Controller
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String description) {
        Task newTask = new Task(description);
        taskRepository.save(newTask);
        return "redirect:/";
    }
}