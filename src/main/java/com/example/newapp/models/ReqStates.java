package com.example.newapp.models;

import javax.persistence.*;

@Entity
@Table(name="req_states")
public class ReqStates {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name= "STATE_ID")
    private Integer stateId;
    @Column(name="state")
    private String state;

    public Integer getStateId() {
        return stateId;
    }
    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public ReqStates() {}

    public ReqStates(String state) {
        this.stateId = stateId;
        this.state = state;
    }
}
