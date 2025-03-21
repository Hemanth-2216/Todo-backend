package com.spboot.todo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "todos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    @EmbeddedId
    private TodoId id;

    private String title;
    private String description;
    private boolean completed;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
