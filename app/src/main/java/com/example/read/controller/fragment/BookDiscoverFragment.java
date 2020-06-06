package com.example.read.controller.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.read.R;
import com.example.read.controller.activity.AddAttentionActivity;
import com.example.read.controller.popupWindow.AvoidPopwindow;
import com.example.read.controller.popupWindow.SharePopupWindow;
import com.example.read.utils.HomeFragmentVPFragmentAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

//这是发现的首页--布局
public class BookDiscoverFragment extends Fragment implements View.OnClickListener {

    private ImageView mImageView,jiPopwindow;
    private ViewPager mViewPager;
    private TabLayout mTableLayout;
    private AvoidPopwindow mAvoidPopwindow;
    private SharePopupWindow mSharePopupWindow;
    private ArrayList<String> listtitle = new ArrayList<>();
    private ArrayList<Fragment> listfragments = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = View.inflate(getActivity(), R.layout.activity_bookdiscover,null);
        dataInitTitle(view);
        init(view);
        return view;
    }


    //初始化布局
    private void init(View view) {
        mImageView = view.findViewById(R.id.bookDiscove_title_img);
        jiPopwindow = view.findViewById(R.id.bookDiscove_title_ji);
        jiPopwindow.setOnClickListener(this);
        mImageView.setOnClickListener(this);
    }

    //TabLayout+viewPager的数据填充和设置
    private void dataInitTitle(View view) {
        //      找到控件
        mTableLayout= view.findViewById(R.id.bookDiscove_title_tabLayout);
        mViewPager = view.findViewById(R.id.bookDiscove_title_viewpager);
        //      将标题添加到arraylist中
        listtitle.add("关注");
        listtitle.add("热门");
        listtitle.add("广场");
        //      遍历list集合，将tab添加到TabLayout中
        for (int i=0;i<listtitle.size();i++){
            mTableLayout.addTab(mTableLayout.newTab().setText(listtitle.get(i)));
        }
        //      将书城中头部页面中的各个板块添加进去
        BookDiscoverAttentionFragment bookDiscoverAttentionFragment = new BookDiscoverAttentionFragment();//关注
        BookDiscoverHotFragment bookDiscoverHotFragment = new BookDiscoverHotFragment();//热门
        BookDiscoverSquareFragment bookDiscoverSquareFragment = new BookDiscoverSquareFragment();//广场
        listfragments.add(bookDiscoverAttentionFragment);
        listfragments.add(bookDiscoverHotFragment);
        listfragments.add(bookDiscoverSquareFragment);

        HomeFragmentVPFragmentAdapter mAdapter = new HomeFragmentVPFragmentAdapter(getFragmentManager(),listfragments,listtitle);
        mViewPager.setOffscreenPageLimit(3);
        //给ViewPager设置适配器
        mViewPager.setAdapter(mAdapter);
        //将TabLayout和ViewPager关联起来。
        mTableLayout.setupWithViewPager(mViewPager);
        //给TabLayout设置适配器
        mTableLayout.setTabsFromPagerAdapter(mAdapter);
        //默认选中第一个：热门 页面
        mTableLayout.getTabAt(1).select();
        //判断当前是第几个被选中的Fragment，如果是第二个，添加好友按钮被隐藏
       mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset,
                                      int positionOffsetPixels) {
               if (position == 2){
                   mImageView.setVisibility(View.GONE);
               }else{
                   mImageView.setVisibility(View.VISIBLE);
               }
           }

           @Override
           public void onPageSelected(int position) {

           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //点击打开添加关注页面
            case R.id.bookDiscove_title_img:
                Intent intent = new Intent(getActivity(), AddAttentionActivity.class);
                startActivity(intent);
                break;
            // 点击打开今日忌页面，弹出Popwindow
            case R.id.bookDiscove_title_ji:
                mAvoidPopwindow = new AvoidPopwindow(getActivity(),itemsOnClick);
                mAvoidPopwindow.showAtLocation(v,Gravity.TOP ,0,0);
                break;
        }
    }




    //为弹出窗口实现监听类
    private View.OnClickListener itemsOnClick = new View.OnClickListener() {

        public void onClick(View v) {
            mAvoidPopwindow.dismiss();
            mAvoidPopwindow.backgroundAlpha(getActivity(),1f);
            switch (v.getId()) {
                case R.id.share:
                    mSharePopupWindow = new SharePopupWindow(getActivity(),itemsOnClicks);
                    mSharePopupWindow.showAtLocation(v,Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                    break;
            }
        }

    };

    //为弹出窗口实现监听类
    private View.OnClickListener itemsOnClicks = new View.OnClickListener() {

        public void onClick(View v) {
            mSharePopupWindow.dismiss();
            mSharePopupWindow.backgroundAlpha(getActivity(), 1f);
            switch (v.getId()) {
                case R.id.weixinghaoyou:
                    Toast.makeText(getActivity(), "微信好友", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.pengyouquan:
                    Toast.makeText(getActivity(), "朋友圈", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.qqhaoyou:
                    Toast.makeText(getActivity(), "QQ好友", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.qqkongjian:
                    Toast.makeText(getActivity(), "QQ空间", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.gengd:
                    Toast.makeText(getActivity(), "更多", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }

    };

}
