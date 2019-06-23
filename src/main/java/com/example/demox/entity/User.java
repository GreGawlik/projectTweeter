package com.example.demox.entity;

import com.example.demox.model.Role;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long id;
private String login;
private String password;
private Role role;
@OneToOne
@JoinColumn(name = "user_details_id")
private UserDetails userDetails;
@Column(name="lock_date")
private Date lockDate;
@Column(name="unlock_date")
private Date unlockDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getLockDate() {
        return lockDate;
    }

    public void setLockDate(Date lockDate) {
        this.lockDate = lockDate;
    }

    public Date getUnlockDate() {
        return unlockDate;
    }

    public void setUnlockDate(Date unlockDate) {
        this.unlockDate = unlockDate;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}