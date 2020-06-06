package com.example.read.controller.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.read.R;
import com.example.read.controller.fragment.CartoonFragment;
import com.example.read.controller.fragment.HorseWomanFragment;
import com.example.read.controller.fragment.ListenbooksFragment;
import com.example.read.controller.fragment.ManChannelFragment;
import com.example.read.controller.fragment.PublishFragment;
import com.example.read.utils.HomeFragmentVPFragmentAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

//这是搜索的界面
public class SearchActivity extends AppCompatActivity {
    private ImageView mImageView;
    private ViewPager mViewPagerContent;
    private TabLayout mTavLayoutTiele;
    private ArrayList<String> listtitle = new ArrayList<>();
    private ArrayList<Fragment> listfragments = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mImageView = findViewById(R.id.search_title_img);


        //返回的单击事件
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        init();

    }

    private void init(){
        mViewPagerContent = findViewById(R.id.viewPager_content);
        mTavLayoutTiele = findViewById(R.id.tabLayout_title);
        listtitle .add("女频");
        listtitle .add("漫画");
        listtitle .add("听书");
        listtitle .add("出版");
        listtitle .add("男频");
        //遍历 listtitle 集合 将title 添加经 TabLayou z中
        for (int i = 0; i <listtitle.size() ; i++) {
            mTavLayoutTiele.addTab(mTavLayoutTiele.newTab().setText(listtitle.get(i)));
        }
        //将搜索页面中的各个板块添加进去
        HorseWomanFragment horseWomanFragment = new HorseWomanFragment();//女频
        CartoonFragment cartoonFragment = new CartoonFragment();//漫画
        ListenbooksFragment listenbooksFragment = new ListenbooksFragment();//听书
        PublishFragment publishFragment =new PublishFragment();//出版
        ManChannelFragment manChannelFragment = new ManChannelFragment();//男频
        listfragments.add(horseWomanFragment);
        listfragments.add(cartoonFragment);
        listfragments.add(listenbooksFragment);
        listfragments.add(publishFragment);
        listfragments.add(manChannelFragment);
        HomeFragmentVPFragmentAdapter mAdapter = new HomeFragmentVPFragmentAdapter(getSupportFragmentManager(),listfragments,listtitle);
        mViewPagerContent.setOffscreenPageLimit(5);
        //给ViewPager设置适配器
        mViewPagerContent.setAdapter(mAdapter);
        //将TabLayout和ViewPager关联起来。
        mTavLayoutTiele.setupWithViewPager(mViewPagerContent);
        //给TabLayout设置适配器
        mTavLayoutTiele.setTabsFromPagerAdapter(mAdapter);

    }
}
