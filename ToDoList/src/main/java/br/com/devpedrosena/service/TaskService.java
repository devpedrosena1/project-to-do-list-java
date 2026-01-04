package br.com.devpedrosena.service;

import br.com.devpedrosena.domainmodel.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<Task> findAll(Task task);
    Optional<Task> findById(Long id);
    Task save(Task task);
    boolean existsById(Long id);
    void deleteById(Long id);
    void delete(Task task);
    Task update(Long id, Task task);

}
