package com.leaf.captain.blog.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="t_category")
public class Category {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="category")
    private List<Article> articles;

    public Category() {
    }

    public Category(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}