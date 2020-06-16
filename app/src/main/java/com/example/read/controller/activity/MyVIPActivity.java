package com.example.read.controller.activity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.read.R;
import com.example.read.controller.adapter.MyVipAdapter;
import com.example.read.model.bean.FruitImageText;
import com.example.read.utils.ObservableScrollView;
import com.example.read.utils.ScrollViewListener;

import java.util.ArrayList;
import java.util.List;

// 我的vip
public class MyVIPActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mClean;
    private RelativeLayout vip_button;
    private LinearLayout mConceal, mShow;
    private ObservableScrollView scrollView_vip;
    private List<FruitImageText> mFruitImageGirl = new ArrayList<>();
    private List<FruitImageText> mFruitImageWomen = new ArrayList<>();
    private List<FruitImageText> mFruitImageCharge = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_vip);
        init();
        initShow();
        woMen();
        schoolgirl();
        charge();
        scrollView();
    }

    // 滑动监听事件
    private void scrollView() {
        scrollView_vip.setScrollViewListener(new ScrollViewListener() {
            @Override
            public void onScrollChanged(ObservableScrollView scrollView, int l, int t, int oldl,
                                        int oldt) {
                if (oldt < t && ((t - oldt) > 15)) {// 向上
                    vip_button.setVisibility(View.GONE);
                } else if (oldt > t && (oldt - t) > 15) {// 向下
                    vip_button.setVisibility(View.VISIBLE);
                }
            }

        });
    }


    // 这是【男生】本期精选部分
    private void woMen() {
        RecyclerView recyclerWoMen = findViewById(R.id.vip_women_recycleview);
        StaggeredGridLayoutManager staggeredGridWoMen = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerWoMen.setLayoutManager(staggeredGridWoMen);
        MyVipAdapter myVipAdapter = new MyVipAdapter(mFruitImageWomen, this);
        recyclerWoMen.setAdapter(myVipAdapter);
        recyclerWoMen.setNestedScrollingEnabled(false);
        initWoMen();
    }

    private void initWoMen() {
        FruitImageText b1 = new FruitImageText("浪迹武侠世界", R.drawable.d1);
        mFruitImageWomen.add(b1);
        FruitImageText b2 = new FruitImageText("我为神仙开的士", R.drawable.d2);
        mFruitImageWomen.add(b2);
        FruitImageText b3 = new FruitImageText("上门医仙", R.drawable.d3);
        mFruitImageWomen.add(b3);
        FruitImageText b4 = new FruitImageText("都市诡医", R.drawable.d4);
        mFruitImageWomen.add(b4);
        FruitImageText b5 = new FruitImageText("最强天尊系统", R.drawable.d5);
        mFruitImageWomen.add(b5);
        FruitImageText b6 = new FruitImageText("异世超级帝皇系统", R.drawable.d6);
        mFruitImageWomen.add(b6);
    }


    // 这是【女生】精选红文部分
    private void schoolgirl() {
        RecyclerView recyclerGirl = findViewById(R.id.vip_schoolgirl_recycleview);
        StaggeredGridLayoutManager staggeredGridGirl = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerGirl.setLayoutManager(staggeredGridGirl);
        MyVipAdapter myVipAdapterG = new MyVipAdapter(mFruitImageGirl, this);
        recyclerGirl.setAdapter(myVipAdapterG);
        recyclerGirl.setNestedScrollingEnabled(false);
        initSchoolgirl();
    }

    private void initSchoolgirl() {
        FruitImageText b7 = new FruitImageText("影后只想做咸鱼", R.drawable.c1);
        mFruitImageGirl.add(b7);
        FruitImageText b8 = new FruitImageText("帝少的心尖宠", R.drawable.c2);
        mFruitImageGirl.add(b8);
        FruitImageText b9 = new FruitImageText("AWM绝地求生", R.drawable.c3);
        mFruitImageGirl.add(b9);
        FruitImageText b10 = new FruitImageText("伪装学渣", R.drawable.c4);
        mFruitImageGirl.add(b10);
        FruitImageText b11 = new FruitImageText("碎玉求珠", R.drawable.c5);
        mFruitImageGirl.add(b11);
        FruitImageText b12 = new FruitImageText("破云", R.drawable.c6);
        mFruitImageGirl.add(b12);
    }

    // 这是【VIP免费】热销排行免费
    private void charge() {
        RecyclerView recyclerCharge = findViewById(R.id.vip_charge_recycleview);
        StaggeredGridLayoutManager staggeredGridCharge = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerCharge.setLayoutManager(staggeredGridCharge);
        MyVipAdapter myVipAdapterCharge = new MyVipAdapter(mFruitImageCharge, this);
        recyclerCharge.setAdapter(myVipAdapterCharge);
        recyclerCharge.setNestedScrollingEnabled(false);
        initCharge();
    }

    private void initCharge() {
        FruitImageText b13 = new FruitImageText("逆天邪神", R.drawable.c1);
        mFruitImageCharge.add(b13);
        FruitImageText b14 = new FruitImageText("最强狂兵", R.drawable.b3);
        mFruitImageCharge.add(b14);
        FruitImageText b15 = new FruitImageText("异世灵武天下", R.drawable.c4);
        mFruitImageCharge.add(b15);
        FruitImageText b16 = new FruitImageText("战神狂飙", R.drawable.b5);
        mFruitImageCharge.add(b16);
        FruitImageText b17 = new FruitImageText("绝世武神", R.drawable.c6);
        mFruitImageCharge.add(b17);
        FruitImageText b18 = new FruitImageText("无敌剑域", R.drawable.b2);
        mFruitImageCharge.add(b18);
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
        scrollView_vip = findViewById(R.id.scrollView_vip);
        vip_button = findViewById(R.id.vip_button);
        mShow = findViewById(R.id.vip_show);
        mClean.setOnClickListener(this);
        mConceal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
