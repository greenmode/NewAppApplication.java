package com.example.newapp.models;

import javax.persistence.*;

@Entity
@Table(name = "ROLE_SET", schema = "C##REVUTSKY", catalog = "")
public class RoleSet {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="role_id", insertable = false, updatable = false)
    private Roles roles;

    @Id
    @Column(name = "ROLE_SET_ID", nullable = false, precision = 0)
    private int roleSetId;
    @Column(name = "ROLE_ID", nullable = true, precision = 0)
    private Integer roleId;
    @Column(name = "USER_ID", nullable = true, precision = 0)
    private Integer userId;

    public int getRoleSetId() { return roleSetId; }
    public void setRoleSetId(int roleSetId) { this.roleSetId = roleSetId; }

    public Integer getRoleId() { return roleId; }
    public void setRoleId(Integer roleId) { this.roleId = roleId; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getRole() { return roles != null ? roles.getRole() : "<none>"; }
    public Roles getRoles() { return roles; }
}
