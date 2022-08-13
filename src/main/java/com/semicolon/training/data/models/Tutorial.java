package com.semicolon.training.data.models;



import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private int level;
    private boolean published;
//    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private LocalDate created = LocalDate.now();

    public Tutorial() {
    }

    public Tutorial(String title, String description, int level, boolean published) {
        this.title = title;
        this.description = description;
        this.level = level;
        this.published = published;
        created = LocalDate.now();
    }
}
