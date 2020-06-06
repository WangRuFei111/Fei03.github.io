package com.example.read.controller.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.read.R;
import com.example.read.controller.activity.CrackDownActivity;
import com.example.read.model.bean.FruitImageTextTow;

import java.util.List;


public class CrackNowAdapter extends RecyclerView.Adapter<CrackNowAdapter.BeautyViewHolder> {
    /**
     * 上下文
     */
    private CrackDownActivity mContext;
    /**
     * 数据集合
     */
        private List<FruitImageTextTow> data;

    public CrackNowAdapter(List<FruitImageTextTow> data, CrackDownActivity context) {
        this.data = data;
        this.mContext = context;
    }

    @Override
    public BeautyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载item 布局文件
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crack_down_now_item, parent
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
            beautyImage = itemView.findViewById(R.id.now_recycleView_img);
            nowTitle = itemView.findViewById(R.id.now_recycleView_title);
            nowText = itemView.findViewById(R.id.now_recycleView_text);
        }
    }

}
