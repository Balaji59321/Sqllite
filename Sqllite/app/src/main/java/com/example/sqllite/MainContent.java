package com.example.sqllite;

import java.io.Serializable;

public class MainContent implements Serializable {

    private int id;
    private String name;
    private String phone;
    private String date;
    private String menu;
    private String price;


    public MainContent(){
    }



    public MainContent(int id, String name, String phone, String date, String menu, String price) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.date = date;
        this.menu = menu;
        this.price = price;
    }

    public MainContent(String name, String phone, String date, String menu, String price) {
        this.name = name;
        this.phone = phone;
        this.date = date;
        this.menu = menu;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
