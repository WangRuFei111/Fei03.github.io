package com.example.read.controller.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.read.R;

// 我的账户部分
public class MyAccountActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mClean;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        init();
    }

    // 初始化绑定布局
    private void init() {
        mClean = findViewById(R.id.my_account_image);
        mClean.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_account_image:
                finish();
                break;
        }
    }
}
