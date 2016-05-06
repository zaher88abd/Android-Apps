package com.abd.zaher88.swaqny.DataClasses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abd.zaher88.swaqny.R;

import java.util.List;

/**
 * Created by Zaher on 29/04/2016.
 */
public class ListCategoryAdapter extends RecyclerView.Adapter<VHCategory> {
    private List<Category> listCategories;
    private LayoutInflater layoutInflater;
    private final OnItemClickListener listener;


    public ListCategoryAdapter(Context context, List<Category> listCategories,OnItemClickListener listener) {
       // clearData();
        this.listCategories = listCategories;
        this.layoutInflater= LayoutInflater.from(context);
        this.listener=listener;
    }

    public interface OnItemClickListener {
        void onItemClick(Category item);
    }


    @Override
    public VHCategory onCreateViewHolder(ViewGroup parent, int viewType) {
      //  Log.d("ListCategoryAdapter","onCreateViewHolder");
        View view=layoutInflater.inflate(R.layout.nav_drawer_list_item,parent,false);
        VHCategory vhCategory=new VHCategory(view);
        return vhCategory;
    }



    @Override
    public void onBindViewHolder(VHCategory holder, int position) {
      //  Log.d("ListCategoryAdapter","onBindViewHolder"+position);
        holder.setData(listCategories.get(position),listener,position);
    }


    @Override
    public int getItemCount() {
        return listCategories.size();
    }

}
