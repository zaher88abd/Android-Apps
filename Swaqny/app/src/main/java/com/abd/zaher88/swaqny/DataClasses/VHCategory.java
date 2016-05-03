package com.abd.zaher88.swaqny.DataClasses;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.abd.zaher88.swaqny.R;

/**
 * Created by Zaher on 29/04/2016.
 */
public class VHCategory extends RecyclerView.ViewHolder {
    TextView tvCatrgorName;
    ImageView imageNext;
    int position;
    int id;

    public VHCategory(View itemView) {
        super(itemView);
        tvCatrgorName = (TextView) itemView.findViewById(R.id.tvNavDrawerItemName);
        imageNext = (ImageView) itemView.findViewById(R.id.imageNext);
    }

    public void setData(final Category category, final ListCategoryAdapter.OnItemClickListener listener, int position) {
        this.tvCatrgorName.setText(category.getName());
        this.id = category.getId();
        if (category.isChildrens())
            imageNext.setBackgroundResource(R.drawable.ic_navigate_next_black_48dp);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(category);
            }
        });
    }
}
