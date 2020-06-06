package com.example.read.controller.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.read.R;
import com.example.read.controller.fragment.BookmallChoicenessFragmgnt;
import com.example.read.model.bean.FruitImageText;

import java.util.List;

public class BoutiqueGrilAdapter extends RecyclerView.Adapter<BoutiqueGrilAdapter.BeautyViewHolder> {
    @NonNull
    //上下文
    private BookmallChoicenessFragmgnt mContext;
    /**
     * 数据集合
     */
    private List<FruitImageText> data;

    public BoutiqueGrilAdapter(List<FruitImageText> data,BookmallChoicenessFragmgnt context){
        this.data= data;
        this.mContext=context;
    }


    @NonNull
    @Override
    public BeautyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //加载布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.choiceness_boutique_item,parent,false);
        return new BeautyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BeautyViewHolder holder, int position) {
        //将数据绑定到item
        FruitImageText beauty = data.get(position);
        holder.beautyImage.setImageResource(beauty.getImageId());
        holder.beautyText.setText(beauty.getContent());
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class BeautyViewHolder extends RecyclerView.ViewHolder {
        ImageView beautyImage;
        TextView beautyText;
        public BeautyViewHolder(@NonNull View itemView) {
            super(itemView);
            //绑定数据
            beautyImage = itemView.findViewById(R.id.boutiqueGril_item_img);
            beautyText = itemView.findViewById(R.id.boutiqueGril_item_txt);
        }
    }
}
