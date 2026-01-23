package br.com.devpedrosena.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.devpedrosena.domainmodel.Task;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "This field is required.")
    private String name;

    @NotBlank(message = "This field is required.")
    private String description;

    @NotNull(message = "This field is required.")
    private Boolean completed;

    @NotNull(message = "This field is required.")
    private Integer priority;

    public static TaskDTO fromEntity(Task task) {
        if (task == null) return null;
        return TaskDTO.builder()
                .id(task.getId())
                .name(task.getName())
                .description(task.getDescription())
                .completed(task.getCompleted())
                .priority(task.getPriority())
                .build();
    }

    public static Task toEntity(TaskDTO dto) {
        if (dto == null) return null;
        return Task.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .completed(dto.getCompleted())
                .priority(dto.getPriority())
                .build();
    }

}
