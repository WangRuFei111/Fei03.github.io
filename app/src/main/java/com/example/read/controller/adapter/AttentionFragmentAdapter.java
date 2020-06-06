package com.example.read.controller.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.read.R;
import com.example.read.controller.fragment.BookDiscoverAttentionFragment;
import com.example.read.model.bean.FruitImageTextTow;

import java.util.List;


public class AttentionFragmentAdapter extends RecyclerView.Adapter<AttentionFragmentAdapter.BeautyViewHolder> {
    /**
     * 上下文
     */
    private BookDiscoverAttentionFragment mContext;
    /**
     * 数据集合
     */
        private List<FruitImageTextTow> data;

    public AttentionFragmentAdapter(List<FruitImageTextTow> data, BookDiscoverAttentionFragment context) {
        this.data = data;
        this.mContext = context;
    }

    @Override
    public BeautyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载item 布局文件
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_add_attention_item, parent
                , false);
        return new BeautyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BeautyViewHolder holder, int position) {
        //将数据设置到item上
        FruitImageTextTow beauty = data.get(position);
        holder.beautyImage.setImageResource(beauty.getImageId());
        holder.nowTitle.setText(beauty.getTitle());
        holder.nowText.setText(beauty.getContent());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class BeautyViewHolder extends RecyclerView.ViewHolder {
        ImageView beautyImage;
        TextView nowTitle,nowText;

        public BeautyViewHolder(View itemView) {
            super(itemView);
            beautyImage = itemView.findViewById(R.id.add_img);
            nowTitle = itemView.findViewById(R.id.add_title);
            nowText = itemView.findViewById(R.id.add_content);
        }
    }

}
