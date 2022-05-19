package com.company.pr14.domain;

import org.springframework.stereotype.Component;
import javax.persistence.*;

@Entity
@Table(name = "contact")
@Component
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @Column
    private String name;
    @Column
    private String tel;
    @Column
    private String email;
    @Column
    private String text;

    public Contact() {
    }

    public Contact(String name, String tel, String email, String text) {
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
