package sk.krytoss.rest.todo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="task")
    private String task;

    @Column(name="created")
    private LocalDateTime created;

    @Column(name="completed")
    private LocalDateTime completed;

    @Column(name="deleted")
    private LocalDateTime deleted;

}
