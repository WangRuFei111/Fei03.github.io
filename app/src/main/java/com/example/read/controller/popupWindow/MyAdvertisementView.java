package com.example.read.controller.popupWindow;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.read.R;


public class MyAdvertisementView extends Dialog implements View.OnClickListener {
    private final Context context;
    private ImageView mImageView;
    private Button mButton;
    public MyAdvertisementView(Context context) {
        super(context);
        setContentView(R.layout.view_dialog_advertisement);
        this.context = context;
        //设置点击布局外则Dialog消失
        setCanceledOnTouchOutside(true);
    }

    public void showDialog() {
        Window window = getWindow();
        //设置弹窗动画
        window.setWindowAnimations(R.style.style_dialog);
        //设置Dialog背景色
        window.setBackgroundDrawableResource(R.color.transparent1);
        WindowManager.LayoutParams wl = window.getAttributes();
        //设置弹窗位置
        wl.gravity = Gravity.CENTER;
        window.setAttributes(wl);
        show();
        mImageView = findViewById(R.id.iv_advertisement);
        mImageView.setOnClickListener(this);
        mButton = findViewById(R.id.mBtu_dalog);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.iv_advertisement:
               //重点 点击图片跳转的页面
//               Intent intent;
//               intent = new Intent(context, AdvertisingActivity.class);
//               context.startActivity(intent);
               break;
           case R.id.mBtu_dalog:
               dismiss();
               break;
           default:
       }
    }
}