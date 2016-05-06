package com.abd.zaher88.swaqny.DataClasses;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.abd.zaher88.swaqny.R;

/**
 * Created by Zaher on 30/04/2016.
 */
public class VHMaterial extends RecyclerView.ViewHolder {
    TextView tvMaterialName;
    TextView tvPrice;
    TextView tvUnit;
    ImageView imageMaterial;
    int id;

    public VHMaterial(View itemView) {
        super(itemView);
        tvMaterialName = (TextView) itemView.findViewById(R.id.tvMaterialName);
        tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
        tvUnit = (TextView) itemView.findViewById(R.id.tvUnitName);
        imageMaterial = (ImageView) itemView.findViewById(R.id.imageMaterial);
    }


    public void setData(final Material material, final ListMaterialAdapter.OnMatrialItemClickListener listener, int position) {
        this.tvMaterialName.setText(material.getName());
        this.id = material.getId();
        this.tvPrice.setText(Double.toString(material.getPrice()));
        this.tvUnit.setText(material.getUnit().getName().toString());
        this.imageMaterial.setImageResource(R.drawable.rsz_bananasf);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(material);
            }
        });

    }
}
