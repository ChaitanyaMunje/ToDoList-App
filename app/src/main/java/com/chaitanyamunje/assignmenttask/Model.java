package com.chaitanyamunje.assignmenttask;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_table")
public class Model {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String task_name;
    private String status;
    private String description;
    private int priority;

    public Model(String task_name, String status, String description, int priority) {
        this.task_name = task_name;
        this.status = status;
        this.description = description;
        this.priority = priority;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}
