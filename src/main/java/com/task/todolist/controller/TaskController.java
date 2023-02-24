package com.task.todolist.controller;



import com.task.todolist.dao.TaskDAO;
import com.task.todolist.domain.Status;
import com.task.todolist.domain.Task;
import com.task.todolist.domain.TaskInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class TaskController {

    @Autowired
    private TaskDAO taskDAO;

    @GetMapping
    public String index(Model model) {
        System.out.println("YYYYYYYYYYY");

        List<Task> tasks = taskDAO.findAll();
        model.addAttribute("tasks", tasks);
        model.addAttribute("task", new Task());
        model.addAttribute("title", "Tasks");
        model.addAttribute("isAdd", true);
        return "index";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute Task task, RedirectAttributes redirectAttributes, Model model) {
        task.setStatus(Status.IN_PROGRESS);
        Task dbTask = taskDAO.save(task);
        if (!dbTask.getDescription().isEmpty()) {
            redirectAttributes.addFlashAttribute("successmessage", "Task is saved");
            return "redirect:/";
        }else {
            model.addAttribute("errormessage", "Try again");
            model.addAttribute("task", task);
            return "index";
        }
    }

    @GetMapping("/getTask/{id}")
    public String getTask(@PathVariable Integer id, Model model) {
        Optional<Task> byId = taskDAO.findById(id);
        List<Task> tasks = taskDAO.findAll();
        if(byId.isPresent()) {
            Task task = byId.get();
            model.addAttribute("tasks", tasks);
            model.addAttribute("task", task);
            model.addAttribute("title", "Edit Task");
            model.addAttribute("isAdd", false);
            return "index";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute Task task, RedirectAttributes redirectAttributes, Model model) {
//        task.setStatus(Status.IN_PROGRESS);
        Task dbTask = taskDAO.save(task);
        if (!dbTask.getDescription().isEmpty()) {
            redirectAttributes.addFlashAttribute("successmessage", "Task is updated");
            return "redirect:/";
        }else {
            model.addAttribute("errormessage", "Try again");
            model.addAttribute("task", task);
            return "index";
        }
    }

    //DeleteMapping - почему-то не работает
    @GetMapping(value = "/deleteTask/{id}")
    public String deleteTask(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        taskDAO.deleteById(id);
        redirectAttributes.addFlashAttribute("successmessage", "Task is deleted");
        return "redirect:/";
    }
}
