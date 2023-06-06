package com.example.employeeManagement.Model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "complaint")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    Long cid;

    @Column(name = "topic")
    String topic;

    @Column(name = "description")
    String description;

    @Column(name = "status")
    int status;
    @Column(name = "uid")
    Long uid;
    @Column(name = "empid")
    Long eid;

    @Column(name = "timestamp")
    Timestamp timestamp;
    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "uid")
    private User user;


    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }
}
