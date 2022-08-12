package com.semicolon.training.data.models;



import javax.persistence.*;
import java.util.Date;

@Entity
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    private int level;
    private boolean published;
    @Temporal(TemporalType.DATE)
    private Date created;

    public Tutorial() {
    }

    public Tutorial(String title, String description, int level, boolean published, Date created) {
        this.title = title;
        this.description = description;
        this.level = level;
        this.published = published;
        this.created = created;
    }
}
