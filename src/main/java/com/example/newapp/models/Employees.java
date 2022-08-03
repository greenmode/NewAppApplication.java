package com.example.newapp.models;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employees {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="position_id", insertable = false, updatable = false)
    private Positions positions;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false, precision = 0)
    private int employeeId;
    @Basic
    @Column(name = "FIO", nullable = true, length = 100)
    private String fio;

    @Column(name = "POSITION_ID", nullable = true, precision = 0)
    private Integer positionId;

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getFio() { return fio; }
    public void setFio(String fio) { this.fio = fio; }

    public Integer getPositionId() { return positionId; }
    public void setPositionId(Integer positionId) { this.positionId = positionId; }

    public String getPosition() { return positions != null ? positions.getPosition() : "<none>"; }
    public Positions getPositions() { return positions; }
}
