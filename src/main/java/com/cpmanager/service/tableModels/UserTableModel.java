package com.cpmanager.service.tableModels;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name="users")
public class UserTableModel implements Serializable {
    @GenericGenerator(name = "userIdGenerator",strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",parameters =  {
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "userSequence"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
    })
    @javax.persistence.Id
    @GeneratedValue(generator = "userIdGenerator")
    Long Id;
    @Column(name = "username")
    String username;
    @Column(name = "firstName")
    String firstName;
    @Column(name = "lastName")
    String lastName;
    @Column(name = "email")
    String email;
    @Column(name = "password")
    String password;
    @Column(name = "street")
    String streeet;
    @Column(name = "street_number")
    int street_number;
    @Column(name = "town")
    String town;
    @Column(name = "role")
    String role;

    @Override
    public String toString() {
        return "UserTableModel{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", streeet='" + streeet + '\'' +
                ", street_number=" + street_number +
                ", town='" + town + '\'' +
                ", role='" + role + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", requestTableModelSet=" + requestTableModelSet +
                ", meetingTableModels=" + meetingTableModels +
                '}';
    }

    @Column(name = "phone_number")
    String phone_number;
    @OneToMany(mappedBy = "userTableModel")
    Set<RequestTableModel> requestTableModelSet=new TreeSet<>();
    @OneToMany(mappedBy = "meetingTableModel")
    Set<MeetingTableModel> meetingTableModels=new TreeSet<>();
    public Long getId() {
        return Id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<RequestTableModel> getRequestTableModelSet() {
        return requestTableModelSet;
    }

    public void setRequestTableModelSet(Set<RequestTableModel> requestTableModelSet) {
        this.requestTableModelSet = requestTableModelSet;
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

    public String getStreeet() {
        return streeet;
    }

    public void setStreeet(String streeet) {
        this.streeet = streeet;
    }

    public int getStreet_number() {
        return street_number;
    }

    public void setStreet_number(int street_number) {
        this.street_number = street_number;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
