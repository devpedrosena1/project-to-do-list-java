package br.com.devpedrosena.service;

import br.com.devpedrosena.domainmodel.Task;
import br.com.devpedrosena.domainmodel.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImplement implements TaskService{

    private final TaskRepository repository;

    @Override
    public Task findAll(Task task) {
        return null;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Task save(Task task) {
        return this.repository.save(task);
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public void delete(Task task) {
        this.repository.delete(task);
    }
}
