package com.semicolon.training.data.models;



import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
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


}
