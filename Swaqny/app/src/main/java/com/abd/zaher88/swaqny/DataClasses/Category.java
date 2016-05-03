package com.abd.zaher88.swaqny.DataClasses;

import java.util.List;

/**
 * Created by Zaher on 28/04/2016.
 */
public class Category {
    private int Id;
    private String Name;
    private boolean Childrens;
    private List<Category> GetParentsMateralsCategoriesResult;
    public List<Category> GetParentsMateralsCategoriesResult(){
        return GetParentsMateralsCategoriesResult;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isChildrens() {
        return Childrens;
    }

    public void setChildrens(boolean childrens) {
        Childrens = childrens;
    }

    public Category() {

    }

    public Category(int id, String name, String nameAr, boolean lastChild) {
        this.Id = id;
        this.Name = name;
        this.Childrens = lastChild;
    }


}



