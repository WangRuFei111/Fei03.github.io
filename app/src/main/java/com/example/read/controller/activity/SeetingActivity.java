package com.example.read.controller.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.read.R;
import com.example.read.utils.Invisible;

// 保存新密码的页面
public class SeetingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mClean,iv_revise;
    private RelativeLayout seeting_clean,seeting_button_bawOut;
    private TextView tv_revise;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeting);

        init();
        isLogin();
    }

    // 软件密码修改的判断是否登陆
    private void isLogin() {
        if (Invisible.invisible){
            iv_revise.setBackgroundDrawable(getResources().getDrawable(R.drawable.right_back)); // 软件加密的右侧图片
            tv_revise.setTextColor(Color.BLACK); // 软件加密的字体--黑色
            seeting_button_bawOut.setVisibility(View.VISIBLE); // 退出按钮--显示
        }else{
            iv_revise.setBackgroundDrawable(getResources().getDrawable(R.drawable.right_gray)); // 软件加密的右侧图片
            tv_revise.setTextColor(Color.parseColor("#BBBBBB")); // 软件加密--灰色
            seeting_button_bawOut.setVisibility(View.GONE);// 退出按钮--隐藏
        }
    }

    // 初始化布局
    private void init() {
        mClean = findViewById(R.id.seeting_title_img);
        tv_revise = findViewById(R.id.tv_revise);
        iv_revise = findViewById(R.id.iv_revise);
        seeting_clean = findViewById(R.id.seeting_clean);
        seeting_button_bawOut = findViewById(R.id.seeting_button_bawOut);
        
        seeting_clean.setOnClickListener(this);
        mClean.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.seeting_title_img:
                finish();
                break;
            // 点击退出按钮
            case R.id.seeting_clean:
                isClean();
                break;
        }
    }

    // 点击退出按钮
    private void isClean() {
        Invisible.invisible = false;
        iv_revise.setBackgroundDrawable(getResources().getDrawable(R.drawable.right_gray)); // 软件加密的右侧图片
        tv_revise.setTextColor(Color.parseColor("#BBBBBB")); // 软件加密--灰色
        seeting_button_bawOut.setVisibility(View.GONE);// 退出按钮--隐藏
    }
}
