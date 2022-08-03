package com.example.newapp.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="requests")
public class Requests implements Serializable {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="employee_id", insertable = false, updatable = false)
    private Employees employees;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", insertable = false, updatable = false)
    private Users users;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="role_id", insertable = false, updatable = false)
    private Roles roles;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="service_id", insertable = false, updatable = false)
    private Services services;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="state_id", insertable = false, updatable = false)
    private ReqStates reqStates;


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="req_id")
    private Integer reqId;
    @Column(name="employee_id")
    private Integer employeeId;
    @Column(name="user_id")
    private Integer userId;
    @Column(name="role_id")
    private Integer roleId;
    @Column(name="service_id")
    private Integer serviceId;
    @Column(name="state_id")
    private Integer stateId;
    @Column(name="coment")
    private String coment;

    public Integer getReqId() {
        return reqId;
    }
    public void setReqId(Integer reqId) {
        this.reqId = reqId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getServiceId() {
        return serviceId;
    }
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getStateId() {
        return stateId;
    }
    public void setStateId(Integer stateId) { this.stateId = stateId; }

    public String getComent() {
        return coment;
    }
    public void setComent(String coment) {
        this.coment = coment;
    }

    public String getFio() { return employees != null ? employees.getFio() : "unknown"; }
    public Employees getEmployees() { return employees; }

    public String getState() {
        return reqStates != null ? reqStates.getState() : "<none>";
    }
    public ReqStates getReqStates() {
        return reqStates;
    }

    public String getUsername() { return users != null ? users.getUsername() : "unknown"; }
    public Users getUsers() { return users; }

    public String getContext() { return services != null ? services.getContext() : "<none>"; }
    public Services getServices() { return services; }

    public String getRole() { return roles != null ? roles.getRole() : "<none>"; }
    public Roles getRoles() { return roles; }

    public Requests() {
    }
    public Requests (Integer employeeId, Integer userId, Integer serviceId, Integer roleId, Integer stateId, String commentToRequest) {
        this.employeeId = employeeId;
        this.userId = userId;
        this.roleId = roleId;
        this.serviceId = serviceId;
        this.stateId = stateId;
        this.coment = commentToRequest;
    }
}
