package com.example.newapp.models;

import javax.persistence.*;

@Entity
public class Positions {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="department_id", insertable = false, updatable = false)
    private Departments departments;

    @Id
    @Column(name = "POSITION_ID", nullable = false, precision = 0)
    private byte positionId;

    private String position;

    @Column(name = "DEPARTMENT_ID", nullable = true, precision = 0)
    private Integer departmentId;

    public byte getPositionId() { return positionId; }
    public void setPositionId(byte positionId) { this.positionId = positionId; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public Integer getDepartmentId() { return departmentId; }
    public void setDepartmentId(Integer departmentId) { this.departmentId = departmentId; }

    public String getName() { return departments != null ? departments.getName() : "<none>"; }
    public Departments getDepartments() { return departments; }
}
