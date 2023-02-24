package com.task.todolist.domain;


import javax.validation.constraints.NotBlank;

public class TaskInfo {
    @NotBlank
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
