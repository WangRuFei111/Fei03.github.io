package com.example.read.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.read.R;
import com.example.read.controller.fragment.EnshrineFragment;
import com.example.read.controller.fragment.EstablishFragment;
import com.example.read.utils.HomeFragmentVPFragmentAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

// 我的书单
public class MyBookListActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mClean;
    private TextView mNew;
    private ViewPager mViewPagerContent;
    private TabLayout mTavLayoutTiele;
    private ArrayList<String> listtitle = new ArrayList<>();
    private ArrayList<Fragment> listfragments = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_booklist);
        init();
        initPager();
    }

    // TabLayout和VierPager的组合
    private void initPager() {
        mViewPagerContent = findViewById(R.id.booklist_viewPager);
        mTavLayoutTiele = findViewById(R.id.booklist_title);
        listtitle .add("已创建");
        listtitle .add("已收藏");
        //遍历 listtitle 集合 将title 添加经 TabLayou z中
        for (int i = 0; i <listtitle.size() ; i++) {
            mTavLayoutTiele.addTab(mTavLayoutTiele.newTab().setText(listtitle.get(i)));
        }
        //将我的书单页面中的各个板块添加进去
        EstablishFragment establishFragment = new EstablishFragment();// 已创建
        EnshrineFragment enshrineFragment = new EnshrineFragment();// 已收藏
        listfragments.add(establishFragment);
        listfragments.add(enshrineFragment);
        mViewPagerContent.setOffscreenPageLimit(5);
        HomeFragmentVPFragmentAdapter mAdapter = new HomeFragmentVPFragmentAdapter(getSupportFragmentManager(),listfragments,listtitle);
        //给ViewPager设置适配器
        mViewPagerContent.setAdapter(mAdapter);
        //将TabLayout和ViewPager关联起来。
        mTavLayoutTiele.setupWithViewPager(mViewPagerContent);
        //给TabLayout设置适配器
        mTavLayoutTiele.setTabsFromPagerAdapter(mAdapter);
    }

    private void init() {
        mClean = findViewById(R.id.booklist_clean);
        mNew = findViewById(R.id.new_construction);
        mNew.setOnClickListener(this);
        mClean.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.booklist_clean:
                finish();
                break;
            // 新建按钮
            case R.id.new_construction:
                intent = new Intent(this,NewConstructionActivity.class);
                startActivity(intent);
                break;
        }
    }

}
