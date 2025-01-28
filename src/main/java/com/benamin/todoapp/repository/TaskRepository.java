package com.benamin.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.benamin.todoapp.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
