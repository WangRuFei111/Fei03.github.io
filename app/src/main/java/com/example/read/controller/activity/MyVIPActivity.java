package com.example.read.controller.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.read.R;

// 我的vip
public class MyVIPActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mClean;
    private LinearLayout mConceal,mShow;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_vip);
        init();
        initShow();
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
