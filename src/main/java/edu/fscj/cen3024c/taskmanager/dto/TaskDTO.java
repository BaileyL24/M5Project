// TaskDTO.java
// D. Singletary
// 9/10/25
// Task DTO for task manager application

package edu.fscj.cen3024c.taskmanager.dto;

import java.util.List;
import java.util.Set;

public class TaskDTO {

    private Integer id;              // include task id
    private String title;
    private String description;
    private String status;
    private String dueDate;

    // Expose only what’s useful for the client
    private String priorityLevel;   // from Priority entity
    private List<String> subtasks;  // titles of subtasks
    private Set<String> users;      // usernames of assigned users

    // Constructors
    public TaskDTO() {}

    public TaskDTO(Integer id, String title, String description, String status, String dueDate,
                   String priorityLevel, List<String> subtasks, Set<String> users) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.priorityLevel = priorityLevel;
        this.subtasks = subtasks;
        this.users = users;
    }

    // Getters & setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDueDate() { return dueDate; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }

    public String getPriorityLevel() { return priorityLevel; }
    public void setPriorityLevel(String priorityLevel) { this.priorityLevel = priorityLevel; }

    public List<String> getSubtasks() { return subtasks; }
    public void setSubtasks(List<String> subtasks) { this.subtasks = subtasks; }

    public Set<String> getUsers() { return users; }
    public void setUsers(Set<String> users) { this.users = users; }
}
