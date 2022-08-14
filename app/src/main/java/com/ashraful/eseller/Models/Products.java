package com.ashraful.eseller.Models;




public class Products {
    private String category,date,pid,image,description,pname,price,time;

    public Products() {
    }

    public Products(String pid, String image, String pname, String price) {
        this.pid = pid;
        this.image = image;
        this.pname = pname;
        this.price = price;
    }

    public Products(String category, String date, String pid, String image, String description, String pname, String price, String time) {
        this.category = category;
        this.date = date;
        this.pid = pid;
        this.image = image;
        this.description = description;
        this.pname = pname;
        this.price = price;
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
