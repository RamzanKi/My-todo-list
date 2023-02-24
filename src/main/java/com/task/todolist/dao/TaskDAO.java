package com.task.todolist.dao;

import com.task.todolist.domain.Status;
import com.task.todolist.domain.Task;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskDAO extends JpaRepository<Task, Integer> {


//    @Query("select t from Task t")
    List<Task> findAll();
//
//    @Query("select t from Task t where t.status = :status")
//    List<Task> findAllByStatus(@Param("status") Status status);
//
//    @Query("select count(t) from Task t where t.status = :status")
//    int countAllByCompleted(@Param("status") Status status);

}
