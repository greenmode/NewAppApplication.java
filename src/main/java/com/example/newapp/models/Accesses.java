package com.example.newapp.models;

import javax.persistence.*;

@Entity
@Table(name = "accesses")
public class Accesses {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "ACCESS_ID", nullable = false, precision = 0)
    private Integer accessId;

    @Column(name = "SERVICE_ID", nullable = false, precision = 0)
    private Integer serviceId;

    @Column(name = "ROLE_ID", nullable = true, precision = 0)
    private Integer roleId;

    public Integer getAccessId() { return accessId; }
    public void setAccessId(Integer accessId) { this.accessId = accessId; }

    public Integer getServiceId() { return serviceId; }
    public void setServiceId(Integer serviceId) { this.serviceId = serviceId; }

    public Integer getRoleId() { return roleId; }
    public void setRoleId(Integer roleId) { this.roleId = roleId; }
}
