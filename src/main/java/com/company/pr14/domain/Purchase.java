package com.company.pr14.domain;

import org.springframework.stereotype.Component;
import javax.persistence.*;

@Entity
@Table(name = "purchase")
@Component
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private Integer idOfEx;
    @Column
    private String name;
    @Column
    private String mail;
    @Column
    private String number;
    @Column
    private String address;
    @Column
    private String type;

    public Purchase() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Purchase(Integer idOfEx, String name, String mail, String number, String address, String type) {
        this.idOfEx = idOfEx;
        this.name = name;
        this.mail = mail;
        this.number = number;
        this.address = address;
        this.type = type;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdOfEx() {
        return idOfEx;
    }

    public void setIdOfEx(Integer idOfEx) {
        this.idOfEx = idOfEx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
