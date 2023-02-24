package com.task.todolist.service;

import com.task.todolist.dao.TaskDAO;
import com.task.todolist.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
//public class TaskService {

//    @Autowired
//    private TaskDAO taskDAO;

//    public List<Task> getAll(int pageNumber, int pageSize) {
//        Pageable pageable = PageRequest.of(pageNumber, pageSize);
//        return taskDAO.getAll(pageable);
//    }

//    public Task saveTask(Task task) {
//        return taskDAO.save(task);
//    }

//    public Task updateTask() {
//
//    }


//}
