// UserDTO.java
// D. Singletary
// 9/24/25
// DTO for User entity (excludes password, includes task titles)

package edu.fscj.cen3024c.taskmanager.dto;

import java.util.Set;

public class UserDTO {

    private Integer id;
    private String username;
    private Set<String> taskTitles; // new field

    // Constructors
    public UserDTO() {}

    public UserDTO(Integer id, String username, Set<String> taskTitles) {
        this.id = id;
        this.username = username;
        this.taskTitles = taskTitles;
    }

    // Getters & setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public Set<String> getTaskTitles() { return taskTitles; }
    public void setTaskTitles(Set<String> taskTitles) { this.taskTitles = taskTitles; }
}
