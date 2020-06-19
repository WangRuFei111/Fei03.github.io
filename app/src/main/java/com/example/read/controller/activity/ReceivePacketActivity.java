package com.example.read.controller.activity;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.read.R;


// 4人成团,抽两万代金券
public class ReceivePacketActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mClean;
    private TextSwitcher tv_switch;
    private String[] mAdvertisements ;
    private final int HOME_AD_RESULT = 1;
    private int mSwitcherCount=0;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                // 广告
                case HOME_AD_RESULT:
                    tv_switch.setText(mAdvertisements[mSwitcherCount % mAdvertisements.length]);
                    mSwitcherCount++;
                    mHandler.sendEmptyMessageDelayed(HOME_AD_RESULT, 4000);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_packet);
        init();
        initView();
    }

    private void initView() {
        tv_switch = findViewById(R.id.tv_switch);
        tv_switch.setFactory(new ViewSwitcher.ViewFactory() {
            // 这里用来创建内部的视图，这里创建TextView，用来显示文字
            public View makeView() {
                TextView tv = new TextView(getApplicationContext());
                // 设置文字的显示单位以及文字的大小
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources()
                        .getDimension(R.dimen.font_size));
                tv.setTextColor(Color.parseColor("#DEDDE3"));
                return tv;
            }
        });
        tv_switch.setInAnimation(getApplicationContext(),
                R.anim.silde_bottom_out);
        tv_switch.setOutAnimation(getApplicationContext(), R.anim.slide_bottom_in);
        mAdvertisements = new String[] { "i*****49561               100阅饼代金券"
                ,"i*****1966               300阅饼代金券"
                ,"i*****68415              100阅饼代金券"
                ,"i*****2085               300阅饼代金券"
                ,"i*****2020               100阅饼代金券"
                ,"i*****90038              100阅饼代金券" };
        mHandler.sendEmptyMessage(HOME_AD_RESULT);
    }


    // 初始化布局控件
    private void init() {
        mClean = findViewById(R.id.receive_title_img);
        mClean.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.receive_title_img:
                finish();
                break;
        }
    }
}
