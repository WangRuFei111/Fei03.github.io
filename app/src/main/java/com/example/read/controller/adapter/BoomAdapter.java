package com.example.read.controller.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.read.R;
import com.example.read.controller.fragment.BookmallSchoolgirlFragment;
import com.example.read.model.bean.FruitImageText;

import java.util.List;


public class BoomAdapter extends RecyclerView.Adapter<BoomAdapter.BeautyViewHolder> {
    /**
     * 上下文
     */
    private BookmallSchoolgirlFragment mContext;
    /**
     * 数据集合
     */
        private List<FruitImageText> data;

    public BoomAdapter(List<FruitImageText> data, BookmallSchoolgirlFragment context) {
        this.data = data;
        this.mContext = context;
    }

    @Override
    public BeautyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载item 布局文件
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schoolgirl_boom_item, parent
                , false);
        return new BeautyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BeautyViewHolder holder, int position) {
        //将数据设置到item上
        FruitImageText beauty = data.get(position);
        holder.beautyImage.setImageResource(beauty.getImageId());
        holder.nameCentent.setText(beauty.getContent());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class BeautyViewHolder extends RecyclerView.ViewHolder {
        ImageView beautyImage;
        TextView nameCentent;

        public BeautyViewHolder(View itemView) {
            super(itemView);
            beautyImage = itemView.findViewById(R.id.boom_item_img);
            nameCentent = itemView.findViewById(R.id.boom_item_txt);
        }
    }

}
