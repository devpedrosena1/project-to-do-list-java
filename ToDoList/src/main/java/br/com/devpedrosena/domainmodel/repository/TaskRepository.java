package br.com.devpedrosena.domainmodel.repository;

import br.com.devpedrosena.domainmodel.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
