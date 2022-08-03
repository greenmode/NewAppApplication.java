package com.example.newapp.models;


import javax.persistence.*;

@Entity
@Table(name="departments")
public class Departments {
    @Id
    @Column(name = "DEP_ID", nullable = false, precision = 0)
    private Integer depId;

    @Column(name = "NAME", nullable = true, length = 50)
    private String name;

    public Integer getDepId() { return depId; }
    public void setDepId(Integer depId) { this.depId = depId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
