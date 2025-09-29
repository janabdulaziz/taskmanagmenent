package com.TaskManagement.taskmanagmenent.dto;

import com.TaskManagement.taskmanagmenent.model.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TaskDTO {

    private String title;
    private boolean completed;

    public static TaskDTO toDto(Task entity) {
        return TaskDTO.builder()
                .title(entity.getTitle())
                .completed(entity.isCompleted())
                .build();
    }
    }

