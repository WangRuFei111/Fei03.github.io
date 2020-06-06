package com.example.read.controller.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.read.R;
import com.example.read.controller.fragment.BookmallChoicenessFragmgnt;
import com.example.read.model.bean.FruitImageText;

import java.util.List;


public class ChoicenessAdapter extends RecyclerView.Adapter<ChoicenessAdapter.BeautyViewHolder> {
    /**
     * 上下文
     */
    private BookmallChoicenessFragmgnt mContext;
    /**
     * 数据集合
     */
        private List<FruitImageText> data;

    public ChoicenessAdapter(List<FruitImageText> data, BookmallChoicenessFragmgnt context) {
        this.data = data;
        this.mContext = context;
    }

    @Override
    public BeautyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载item 布局文件
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.choiceness_gril_item, parent
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
            beautyImage = itemView.findViewById(R.id.girl_item_img);
            nameCentent = itemView.findViewById(R.id.girl_item_txt);
        }
    }

}
