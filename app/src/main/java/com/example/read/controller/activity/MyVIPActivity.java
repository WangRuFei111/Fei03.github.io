package com.example.read.controller.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.read.R;
import com.example.read.controller.adapter.MyVipAdapter;
import com.example.read.model.bean.FruitImageText;

import java.util.ArrayList;
import java.util.List;

// 我的vip
public class MyVIPActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mClean;
    private LinearLayout mConceal,mShow;

    private List<FruitImageText> mFruitImageWomen = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_vip);
        init();
        initShow();
        woMen();
    }


    // 这是【男生】本期精选部分
    private void woMen() {
        RecyclerView recyclerWoMen = findViewById(R.id.vip_women_recycleview);
        StaggeredGridLayoutManager staggeredGridWoMen = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerWoMen.setLayoutManager(staggeredGridWoMen);
        MyVipAdapter myVipAdapter = new MyVipAdapter(mFruitImageWomen,this);
        recyclerWoMen.setAdapter(myVipAdapter);
        recyclerWoMen.setNestedScrollingEnabled(false);
        initWoMen();
    }
    private void initWoMen(){
        FruitImageText b1 = new FruitImageText("浪迹武侠世界",R.drawable.c1);
        mFruitImageWomen.add(b1);
        FruitImageText b2= new FruitImageText("我为神仙开的士",R.drawable.c2);
        mFruitImageWomen.add(b2);
        FruitImageText b3 = new FruitImageText("上门医仙",R.drawable.c3);
        mFruitImageWomen.add(b3);
        FruitImageText b4 = new FruitImageText("都市诡医",R.drawable.c4);
        mFruitImageWomen.add(b4);
        FruitImageText b5= new FruitImageText("最强天尊系统",R.drawable.c5);
        mFruitImageWomen.add(b5);
        FruitImageText b6 = new FruitImageText("异世超级帝皇系统",R.drawable.c6);
        mFruitImageWomen.add(b6);
    }


    // 初始化布局的时候隐藏查看全部部分
    private void initShow() {
        mConceal.setVisibility(View.VISIBLE);
        mShow.setVisibility(View.GONE);
    }

    // 初始化布局
    private void init() {
       mClean = findViewById(R.id.my_vip_image);
       mConceal = findViewById(R.id.vip_conceal);
       mShow = findViewById(R.id.vip_show);
       mClean.setOnClickListener(this);
       mConceal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_vip_image:
                finish();
                break;
            // 点击隐藏查看全部
            case R.id.vip_conceal:
                mConceal.setVisibility(View.GONE);
                mShow.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        initShow();
    }
}
