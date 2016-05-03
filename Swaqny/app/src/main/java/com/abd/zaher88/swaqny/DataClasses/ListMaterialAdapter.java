package com.abd.zaher88.swaqny.DataClasses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abd.zaher88.swaqny.R;

import java.util.List;

/**
 * Created by Zaher on 30/04/2016.
 */
public class ListMaterialAdapter extends RecyclerView.Adapter<VHMaterial> {

    public interface OnItemClickListener {
        void onItemClick(Material item);
    }

    private List<Material> listMatrial;
    private LayoutInflater layoutInflater;
    private final OnItemClickListener listener;

    public ListMaterialAdapter(Context context, List<Material> listMatrial, OnItemClickListener listener) {
        this.listMatrial = listMatrial;
        this.layoutInflater = LayoutInflater.from(context);
        this.listener = listener;
    }


    @Override
    public VHMaterial onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_material_item, parent, false);
        VHMaterial vhMaterial = new VHMaterial(view);
        return vhMaterial;
    }

    @Override
    public void onBindViewHolder(VHMaterial holder, int position) {
        holder.setData(listMatrial.get(position), listener, position);
    }

    @Override
    public int getItemCount() {
        return listMatrial.size();
    }
}
