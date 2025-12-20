package br.com.devpedrosena.domainmodel;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TASK")
    private @Getter @Setter Long id;

    @Column(name = "NAME")
    private @Getter @Setter String name;

    @Column(name = "DESCRIPTION")
    private @Getter @Setter String description;

    @Column(name = "COMPLETED")
    private @Getter @Setter boolean completed;

    @Column(name = "PRIORITY")
    private @Getter @Setter int priority;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "=== Task ===" +
                "\nid: " + id +
                "\nname: " + name +
                "\ndescription: " + description +
                "\ncompleted: " + completed +
                "\npriority: " + priority;
    }
}
