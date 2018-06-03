package com.soling.store.model;



public class Employee {
    private Long deptId;
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

    public Employee(Long id, String name,Long deptId) {
        super();
        this.id = id;
        this.name = name;
        this.deptId = deptId;
    }

    public Employee() {
        super();
    }
}

