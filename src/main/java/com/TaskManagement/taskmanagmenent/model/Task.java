package com.TaskManagement.taskmanagmenent.model;

import jakarta.persistence.*;
import lombok.Data;

@Table
@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private boolean completed;


}
