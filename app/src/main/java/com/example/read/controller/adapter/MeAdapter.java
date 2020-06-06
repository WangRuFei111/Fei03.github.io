package com.example.read.controller.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.read.R;
import com.example.read.model.bean.FruitImageText;
import com.example.read.utils.OnItemClickListener;

import java.util.List;

public class MeAdapter extends RecyclerView.Adapter<MeAdapter.ViewHolder> {

    private List<FruitImageText> mFruitList;
    private OnItemClickListener onItemClickListener;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fruitImage;
        TextView fruitName;

        private ViewHolder(View view) {
            super(view);
            fruitImage = view.findViewById(R.id.me_item_img);
            fruitName =  view.findViewById(R.id.me_item_text);
        }

    }

    public MeAdapter(List<FruitImageText> fruitList) {
        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.me_vip_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        FruitImageText fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getContent());
        if (onItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListeners){
        this.onItemClickListener = onItemClickListeners;
    }
}