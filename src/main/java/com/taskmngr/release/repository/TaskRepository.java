package com.taskmngr.release.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmngr.release.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}