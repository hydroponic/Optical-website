package com.company.pr14.domain;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Entity
@EnableAspectJAutoProxy
@Table(name = "frame")
@Component
public class Frame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private String sex;
    @Column
    private String color;
    @Column
    private String metal;
    @Column
    private int cost;
    @Column
    private String brand;
    @Column
    private String img;
    @Column
    private String type;
    private static String cl ="frame";
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static String getCl() {
        return cl;
    }

    public static void setCl(String cl) {
        Frame.cl = cl;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Frame() {}

    public Frame(Integer id, String name, String sex, String color, String metal, int cost, String brand) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.color = color;
        this.metal = metal;
        this.cost = cost;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getColor() {
        return color;
    }

    public String getMetal() {
        return metal;
    }

    public String getBrand() {
        return brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
