package com.soling.store.model;



public class Employee {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Employee() {
        super();
    }
}

