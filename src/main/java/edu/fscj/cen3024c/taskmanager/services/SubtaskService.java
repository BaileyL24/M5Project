// SubtaskService.java
// D. Singletary
// 11/20/25
// Subtask service for task manager application

package edu.fscj.cen3024c.taskmanager.services;

import edu.fscj.cen3024c.taskmanager.dto.CreateSubtaskRequestDTO;
import edu.fscj.cen3024c.taskmanager.dto.SubtaskDTO;
import edu.fscj.cen3024c.taskmanager.dto.UpdateSubtaskRequestDTO;
import edu.fscj.cen3024c.taskmanager.entities.Subtask;
import edu.fscj.cen3024c.taskmanager.entities.Task;
import edu.fscj.cen3024c.taskmanager.exceptions.SubtaskNotFoundException;
import edu.fscj.cen3024c.taskmanager.exceptions.TaskNotFoundException;
import edu.fscj.cen3024c.taskmanager.repositories.SubtaskRepository;
import edu.fscj.cen3024c.taskmanager.repositories.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubtaskService {

    private final SubtaskRepository subtaskRepository;
    private final TaskRepository taskRepository;

    public SubtaskService(SubtaskRepository subtaskRepository, TaskRepository taskRepository) {
        this.subtaskRepository = subtaskRepository;
        this.taskRepository = taskRepository;
    }

    // ===== READ =====

    @Transactional(readOnly = true)
    public List<SubtaskDTO> findAll() {
        return subtaskRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public SubtaskDTO findById(Integer id) {
        Subtask subtask = subtaskRepository.findById(id)
                .orElseThrow(() -> new SubtaskNotFoundException(id));
        return convertToDTO(subtask);
    }

    @Transactional(readOnly = true)
    public Subtask findByIdEntity(Integer id) {
        return subtaskRepository.findById(id)
                .orElseThrow(() -> new SubtaskNotFoundException(id));
    }

    // ===== CREATE =====

    @Transactional
    public SubtaskDTO createSubtask(CreateSubtaskRequestDTO request) {

        Task parentTask = taskRepository.findById(request.getTaskId())
                .orElseThrow(() -> new TaskNotFoundException(request.getTaskId()));

        Subtask subtask = new Subtask(
                request.getTitle(),
                request.getStatus(),   // Enum used directly
                parentTask
        );

        Subtask saved = subtaskRepository.save(subtask);
        return convertToDTO(saved);
    }

    // ===== UPDATE =====

    @Transactional
    public SubtaskDTO updateSubtask(Integer id, UpdateSubtaskRequestDTO request) {

        Subtask existing = findByIdEntity(id);

        Task parentTask = taskRepository.findById(request.getTaskId())
                .orElseThrow(() -> new TaskNotFoundException(request.getTaskId()));

        existing.setTitle(request.getTitle());
        existing.setStatus(request.getStatus());  // Enum used directly
        existing.setTask(parentTask);

        Subtask updated = subtaskRepository.save(existing);
        return convertToDTO(updated);
    }

    public void deleteById(Integer id) {
        if (!subtaskRepository.existsById(id)) {
            throw new SubtaskNotFoundException(id);
        }
        subtaskRepository.deleteById(id);
    }

    // ===== Entity -> DTO =====

    public SubtaskDTO convertToDTO(Subtask subtask) {

        Integer taskId = (subtask.getTask() != null)
                ? subtask.getTask().getId()
                : null;

        return new SubtaskDTO(
                subtask.getId(),
                subtask.getTitle(),
                subtask.getStatus().name(),  // Convert enum to String for DTO
                taskId
        );
    }
}
