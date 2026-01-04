package br.com.devpedrosena.service;

import br.com.devpedrosena.domainmodel.Task;
import br.com.devpedrosena.domainmodel.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImplement implements TaskService{

    private final TaskRepository repository;

    @Override
    public List<Task> findAll(Task task) {
        return new ArrayList<>(
                this.repository.findAll()
        );
    }

    @Override
    public Optional<Task> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Task save(Task task) {
        return this.repository.save(task);
    }

    @Override
    public boolean existsById(Long id) {
        return this.repository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public void delete(Task task) {
        this.repository.delete(task);
    }

    @Override
    public Task update(Long id, Task task) {
        Task taskFromDatabase = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found!"));

        return this.repository.save(task);
    }
}
