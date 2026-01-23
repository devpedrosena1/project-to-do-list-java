package br.com.devpedrosena.presentation.controller;
import br.com.devpedrosena.domainmodel.Task;
import br.com.devpedrosena.presentation.dto.TaskDTO;
import br.com.devpedrosena.service.TaskService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
public class TaskController {

    public final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskDTO>> findAll() {
        List<TaskDTO> list = taskService.findAll()
                .stream()
                .map(TaskDTO::fromEntity)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable Long id) {
        return this.taskService.findById(id)
                .map(TaskDTO::fromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TaskDTO> save(@Valid @RequestBody TaskDTO dto) {
        Task saved = this.taskService.save(TaskDTO.toEntity(dto));
        return new ResponseEntity<>(TaskDTO.fromEntity(saved), HttpStatus.CREATED);
    }

}
