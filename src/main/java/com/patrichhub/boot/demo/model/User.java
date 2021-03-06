package com.patrichhub.boot.demo.model;

import org.hibernate.validator.constraints.Currency;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Created by Patrick-PC on 12.06.2018.
 */
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private int id;
    @Column(name="email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please privide an Email")
    private String email;
    @Column(name="password")
    @Length(min=5, message = "*Your password must have at least 5 characteres")
    @NotEmpty(message="*Please private your password")
    @Transient
    private String password;
    @Column(name="name")
    @NotEmpty(message = "*Please privide your name")
    private String name;
    @Column(name="last_name")
    @NotEmpty(message = "*Please privide your last name")
    private String lastName;
    @Column(name = "active")
    private int active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
