package com.task.todolist.dao;

import com.task.todolist.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskDAO extends JpaRepository<Task, Integer> {

    List<Task> findAll();

}
