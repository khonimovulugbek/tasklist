package evolution.fintech.tasklist.web.controller;

import evolution.fintech.tasklist.domain.task.Task;
import evolution.fintech.tasklist.service.TaskService;
import evolution.fintech.tasklist.web.dto.task.TaskDto;
import evolution.fintech.tasklist.web.dto.validation.OnUpdate;
import evolution.fintech.tasklist.web.mappers.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
@Validated
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @PutMapping
    public TaskDto update(@Validated(OnUpdate.class) @RequestBody TaskDto dto) {
        Task task = taskMapper.toEntity(dto);
        Task updatedTask = taskService.update(task);
        return taskMapper.toDto(updatedTask);
    }

    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable Long id) {
        Task task = taskService.getById(id);
        return taskMapper.toDto(task);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        taskService.delete(id);
    }
}
