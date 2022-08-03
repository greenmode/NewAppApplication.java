package com.example.newapp.models;

import javax.persistence.*;

@Entity
@Table(name = "USER_SET")
public class UserSet {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", insertable = false, updatable = false)
    private Users users;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_SET_ID", nullable = false, precision = 0)
    private int id;

    @Column(name = "EMPLOYEE_ID", nullable = true, precision = 0)
    private Integer employeeId;

    @Column(name = "USER_ID", nullable = false, precision = 0)
    private int userId;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Integer getEmployeeId() { return employeeId; }
    public void setEmployeeId(Integer employeeId) { this.employeeId = employeeId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getUsername() { return users != null ? users.getUsername() : "unknown"; }
    public Users getUsers() { return users; }
}
