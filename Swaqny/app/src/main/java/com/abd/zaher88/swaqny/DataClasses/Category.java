package com.abd.zaher88.swaqny.DataClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zaher on 28/04/2016.
 */
public class Category {
    private List<Category> Childrens;
    private int Id;
    private String Name;
    private Category Parent;
    private List<Category> GetAllMaterialsCategoriesResult;
    private List<Category> GetAllMaterialsCategoriesByParentIdResult;
    private List<Category> GetParentsMateralsCategoriesResult;

    public List<Category> getGetParentsMateralsCategoriesResult() {
        return GetParentsMateralsCategoriesResult;
    }

    public List<Category> getGetAllMaterialsCategoriesByParentIdResult() {
        return GetAllMaterialsCategoriesByParentIdResult;
    }

    public List<Category> getChildrens() {
        return this.Childrens;
    }

    public void setChildrens(ArrayList<Category> Childrens) {
        this.Childrens = Childrens;
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Category getParent() {
        return this.Parent;
    }

    public void setParent(Category Parent) {
        this.Parent = Parent;
    }

    public List<Category> getGetAllMaterialsCategoriesResult() {
        return this.GetAllMaterialsCategoriesResult;
    }

}



