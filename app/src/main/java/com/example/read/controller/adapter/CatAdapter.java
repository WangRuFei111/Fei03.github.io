package com.example.read.controller.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.read.R;
import com.example.read.controller.activity.AllChannelsActivity;
import com.example.read.controller.fragment.BookmallSchoolgirlFragment;
import com.example.read.model.bean.FruitText;

import java.util.List;


public class CatAdapter extends RecyclerView.Adapter<CatAdapter.BeautyViewHolder> {
    /**
     * 上下文
     */
    private AllChannelsActivity mContext;
    /**
     * 数据集合
     */
        private List<FruitText> data;

    public CatAdapter(List<FruitText> data, AllChannelsActivity context) {
        this.data = data;
        this.mContext = context;
    }

    @Override
    public BeautyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载item 布局文件
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.allchannels_cat_item, parent
                , false);
        return new BeautyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BeautyViewHolder holder, int position) {
        //将数据设置到item上
        FruitText beauty = data.get(position);
        holder.nameCentent.setText(beauty.getContent());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class BeautyViewHolder extends RecyclerView.ViewHolder {
        TextView nameCentent;

        public BeautyViewHolder(View itemView) {
            super(itemView);
            nameCentent = itemView.findViewById(R.id.cat_item_txt);
        }
    }

}
