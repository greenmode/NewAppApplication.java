package com.example.newapp.models;

import javax.persistence.*;

@Entity
@Table(name="services")
public class Services {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="service_id")
    private Integer serviceId;

    private String context;
    private String body;

    public Integer getServiceId() {
        return serviceId;
    }
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getContext() {
        return context;
    }
    public void setContext(String context) {
        this.context = context;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
}
