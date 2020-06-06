package com.example.read.controller.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.read.R;
import com.example.read.controller.adapter.MyPagerAdapter;
import com.example.read.utils.RotationPageTransformer;

//从书架中跳转到每日推荐部分
public class RecommendActivity extends AppCompatActivity {

    private static final int[] drawableIds = new int[]{R.drawable.look1,R.drawable.look2, R.drawable.look3,
            R.drawable.look4,R.drawable.look5};
    private ViewPager mViewPager;
    private MyPagerAdapter mPagerAdapter;
    private ImageView mRecommend_title_img;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);
        mRecommend_title_img = findViewById(R.id.recommend_title_img);
        //点击返回按钮返回到上个页面
        mRecommend_title_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initViews();
    }

    private void initViews() {
        mViewPager = findViewById(R.id.recommend_viewpager);
        mPagerAdapter = new MyPagerAdapter(drawableIds,this);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setPageTransformer(true,new RotationPageTransformer());
        mViewPager.setOffscreenPageLimit(2);//设置预加载的数量，这里设置了2,会预加载中心item左边两个Item和右边两个Item
        mViewPager.setPageMargin(10);//设置两个Page之间的距离
    }
}
