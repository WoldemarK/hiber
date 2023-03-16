package com.example.hiber.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
public class Section {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    public Section(String name) {
        this.name = name;
    }

    //    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "child_section",
//            joinColumns = @JoinColumn(name = "section_id"),
//            inverseJoinColumns = @JoinColumn(name = "child_id"))
    @ManyToMany(mappedBy = "sections", cascade = CascadeType.ALL)
    private List<Children> childrens;

    public void addChildren(Children children) {
        if (this.childrens == null) {
            this.childrens = new ArrayList<>();
            this.childrens.add(children);
        }
    }

    public Section() {
    }

    public List<Children> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Children> childrens) {
        this.childrens = childrens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
