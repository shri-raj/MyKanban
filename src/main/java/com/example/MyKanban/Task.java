package com.example.MyKanban;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @NonNull
    @Column(name="title")
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NonNull
    @Column(name="description")
    @NotBlank(message = "Description cannot be blank")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name="state")
    private TaskState state;  // Use the enum instead of String, States: ToDo, In Progress, Completed

}
