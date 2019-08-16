package com.armby.soshapi.status;

import com.armby.soshapi.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

// Tell hibernate this is an entity
@Entity
// Create a table with the name of "statuses"
@Table(name = "statuses")
// Write my getters and setters for me
@Data
public class Status {

    // Tell hibernate this is an id field
    @Id
    // When you generate the id, let the database decide how to increment it
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Create a column named "content"
    @Column
    private String content;

    // Create a column named "created_at"
    @Column
    private Date created_at;

    // This is a many-to-one relationship, it's not optional
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // This is a join column that is non-nullable, called "user_id"
    @JoinColumn(name = "user_id", nullable = false)
    // On delete, make sure that everything related is also deleted
    @OnDelete(action = OnDeleteAction.CASCADE)
    // Don't show this data when calling for statuses via an API call
    @JsonIgnore
    private User user;

    // No-arg constructor required by hibernate
    public Status() {}

}
