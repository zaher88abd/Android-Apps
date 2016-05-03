package com.abd.zaher88.swaqny.DataClasses;

/**
 * Created by Zaher on 30/04/2016.
 */
public class Material {
    private int CategoryId;
    private int Id;
    private String CategoryName;
    private Unit Unit;
    private String ImgUrl;
    private String Name;
    private int Price;

    public int getCategoryId() {
        return this.CategoryId;
    }

    public void setCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
    }


    public String getCategoryName() {
        return this.CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }


    public int getId() {
        return this.Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }


    public String getImgExtension() {
        return this.ImgUrl;
    }

    public void setImgExtension(String ImgExtension) {
        this.ImgUrl = ImgExtension;
    }


    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }


    public int getPrice() {
        return this.Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }


    public Unit getUnit() {
        return this.Unit;
    }

    public void setUnit(Unit Unit) {
        this.Unit = Unit;
    }
}
