package com.armby.soshapi.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String company;

    @Column
    private String address;

    @Column
    private String photo_url;

    @Column
    private String password;

    public User() {}

    public User(String name, String phone, String email, String company, String address, String photo_url, String password) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.company = company;
        this.address = address;
        this.photo_url = photo_url;
        this.password = password;
    }
}
