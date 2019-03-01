package org.udg.pds.springtodo.entity;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "usergroup")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "description"}))
public class Group {

    @Id
    protected long Id;
    private String name;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonView(Views.Complete.class)
    private User owner;

    public Group(long Id ,String name, String description) {
        this.Id=Id;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
