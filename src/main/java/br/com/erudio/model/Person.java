package br.com.erudio.model;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name= "person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name", nullable = false)
    private String firtName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    @Column(name="last_name", nullable = false)
    private String lastName;
    @Column(name="address")
    private String address;

    public Person() {

    }
    @Column(name="gender")
    private String gender;
}
