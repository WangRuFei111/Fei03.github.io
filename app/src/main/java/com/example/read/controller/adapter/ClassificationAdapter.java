package com.example.read.controller.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.read.R;
import com.example.read.model.bean.FruitText;
import com.example.read.utils.OnItemClickListener;

import java.util.List;

public class ClassificationAdapter extends RecyclerView.Adapter<ClassificationAdapter.ViewHolder> {
    private List mFruiList;
    private OnItemClickListener onItemClickListener;



    public ClassificationAdapter(List<FruitText> mFruiList){
        this.mFruiList = mFruiList;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.classification_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        FruitText fruitText = (FruitText) mFruiList.get(position);
        holder.mTextView.setText(fruitText.getTextId());
        if (onItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(position);
                    notifyDataSetChanged();
                }
            });
            if (position == getmPosition()){
                holder.mTextView.setBackgroundResource(R.drawable.shape_left);
            }else{
                holder.mTextView.setBackgroundColor(Color.parseColor("#FCFCFC"));
            }

        }
    }

    private int mPosition;
    private int getmPosition(){
        return mPosition;
    }

    public void setmPosition(int mPosition) {
        this.mPosition = mPosition;
    }

    @Override
    public int getItemCount() {
        return mFruiList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.classification_item_text);
        }


    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListeners){
        this.onItemClickListener = onItemClickListeners;
    }
}
