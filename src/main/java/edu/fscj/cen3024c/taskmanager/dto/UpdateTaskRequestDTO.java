// UpdateTaskRequestDTO.java
// D. Singletary
// 11/20/25
// Minimal request DTO for updating a Task

package edu.fscj.cen3024c.taskmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UpdateTaskRequestDTO {

    @Schema(example = "Finish Module 5 Project", description = "Updated task title")
    @NotBlank(message = "title is required")
    @Size(min = 1, max = 100, message = "title must be 1 to 100 characters")
    private String title;

    @Schema(example = "Complete all DTOs and test with Swagger UI", description = "Updated task description (optional)")
    @Size(max = 500, message = "description must be 500 characters or less")
    private String description;

    @Schema(example = "IN_PROGRESS", description = "Updated status (e.g., PENDING, IN_PROGRESS, COMPLETED)")
    @NotBlank(message = "status is required")
    @Size(max = 20, message = "status must be 20 characters or less")
    private String status;

    @Schema(example = "2025-10-12", description = "Updated due date in YYYY-MM-DD format")
    @NotBlank(message = "dueDate is required")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "dueDate must be in YYYY-MM-DD format")
    private String dueDate;

    @Schema(example = "3", description = "Updated priority id (foreign key reference)")
    private Integer priorityId;

    public UpdateTaskRequestDTO() {}

    public UpdateTaskRequestDTO(String title, String description, String status, String dueDate, Integer priorityId) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.priorityId = priorityId;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDueDate() { return dueDate; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }

    public Integer getPriorityId() { return priorityId; }
    public void setPriorityId(Integer priorityId) { this.priorityId = priorityId; }
}
