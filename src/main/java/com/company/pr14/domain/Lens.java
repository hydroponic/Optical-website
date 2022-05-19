package com.company.pr14.domain;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Entity
@EnableAspectJAutoProxy
@Table(name = "lens")
@Component
public class Lens {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private int cost;
    @Column
    private String brand;
    @Column
    private String type;
    @Column
    private String material;
    @Column
    private String img;
    private static String cl ="lens";
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Lens() {}

    public String getName() {
        return name;
    }

    public static String getCl() {
        return cl;
    }

    public static void setCl(String cl) {
        Lens.cl = cl;
    }

    public Lens(Integer id, String name, int cost, String brand, String type, String material) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.brand = brand;
        this.type = type;
        this.material = material;
    }

    public String getBrand() {
        return brand;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
