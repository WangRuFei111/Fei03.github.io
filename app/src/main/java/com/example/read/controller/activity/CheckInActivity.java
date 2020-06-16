package com.example.read.controller.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.read.R;
import com.example.read.controller.popupWindow.MyAdvertisementView;

// 签到页面
public class CheckInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);
        MyAdvertisementView myAdvertisementView = new MyAdvertisementView(this);
        myAdvertisementView.showDialog();
    }
}
