package com.abd.zaher88.swaqny.DataClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zaher on 30/04/2016.
 */
public class Material {
    private int CategoryId;
    private String CategoryName;
    private int Id;
    private ArrayList<Byte> Img;
    private String ImgExtension;
    private String Name;
    private int Price;
    private Unit Unit;
    private List<Material> GetFirstMateralsResult;
    private List<Material> GetAllMaterialsByCategoryIdResult;

    public List<Material> getGetAllMaterialsByCategoryIdResult() {
        return GetAllMaterialsByCategoryIdResult;
    }

    public void setGetAllMaterialsByCategoryIdResult(List<Material> getAllMaterialsByCategoryIdResult) {
        GetAllMaterialsByCategoryIdResult = getAllMaterialsByCategoryIdResult;
    }

    public List<Material> getGetFirstMateralsResult() {
        return GetFirstMateralsResult;
    }

    public void setGetFirstMateralsResult(List<Material> getFirstMateralsResult) {
        GetFirstMateralsResult = getFirstMateralsResult;
    }


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

    public ArrayList<Byte> getImg() {
        return this.Img;
    }

    public void setImg(ArrayList<Byte> Img) {
        this.Img = Img;
    }

    public String getImgExtension() {
        return this.ImgExtension;
    }

    public void setImgExtension(String ImgExtension) {
        this.ImgExtension = ImgExtension;
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
