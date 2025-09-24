// UserDTO.java
// D. Singletary
// 9/10/25
// DTO for User entity (excludes password)

package edu.fscj.cen3024c.taskmanager.dto;

public class UserDTO {

    private Integer id;
    private String username;

    // Constructors
    public UserDTO() {}

    public UserDTO(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    // Getters & setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
