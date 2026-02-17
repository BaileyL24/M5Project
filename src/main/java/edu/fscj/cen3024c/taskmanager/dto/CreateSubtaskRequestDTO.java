// CreateSubtaskRequestDTO.java
// D. Singletary
// 11/20/25
// Minimal request DTO for creating a Subtask

package edu.fscj.cen3024c.taskmanager.dto;

import edu.fscj.cen3024c.taskmanager.enums.SubtaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateSubtaskRequestDTO {

    @Schema(example = "Write Swagger screenshots", description = "Short subtask title")
    @NotBlank(message = "title is required")
    @Size(min = 1, max = 100, message = "title must be 1 to 100 characters")
    private String title;

    @Schema(description = "Subtask status", example = "PENDING")
    @NotNull(message = "status is required")
    private SubtaskStatus status;

    @Schema(example = "1", description = "Parent Task id (foreign key reference)")
    @NotNull(message = "taskId is required")
    private Integer taskId;

    public CreateSubtaskRequestDTO() {}

    public CreateSubtaskRequestDTO(String title, SubtaskStatus status, Integer taskId) {
        this.title = title;
        this.status = status;
        this.taskId = taskId;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public SubtaskStatus getStatus() { return status; }
    public void setStatus(SubtaskStatus status) { this.status = status; }

    public Integer getTaskId() { return taskId; }
    public void setTaskId(Integer taskId) { this.taskId = taskId; }
}