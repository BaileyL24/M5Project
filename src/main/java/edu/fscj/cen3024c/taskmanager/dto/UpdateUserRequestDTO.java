// UpdateUserRequestDTO.java
// D. Singletary
// 11/20/25
// Minimal request DTO for updating a user (includes password)

package edu.fscj.cen3024c.taskmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateUserRequestDTO {

    @Schema(example = "profs", description = "Updated username (must remain unique)")
    @NotBlank(message = "username is required")
    @Size(min = 3, max = 50, message = "username must be 3 to 50 characters")
    private String username;

    @Schema(example = "secret123", description = "Updated password (not returned in responses)")
    @NotBlank(message = "password is required")
    @Size(min = 8, max = 100, message = "password must be 8 to 100 characters")
    private String password;

    public UpdateUserRequestDTO() {}

    public UpdateUserRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
