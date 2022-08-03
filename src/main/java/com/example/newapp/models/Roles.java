package com.example.newapp.models;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Roles {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="role_id")
    private Integer roleId;
    @Column(name="role")
    private String role;

    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer role_id) {
        this.roleId = role_id;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public Roles() {}
    public Roles(String role) {
        this.roleId = roleId;
        this.role = role;
    }
}
