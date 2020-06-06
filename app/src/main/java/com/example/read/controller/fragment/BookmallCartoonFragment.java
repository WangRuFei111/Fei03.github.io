package com.example.read.controller.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.example.read.R;
import com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

//这是书架的标题栏的漫画板块
public class BookmallCartoonFragment extends Fragment {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ScrollView mScrollView;
    private Banner mBanner;
    private Button sillyButton,dlDlButton;
    private RelativeLayout relativeLayout,dlRecycleLayout;
    private List<Integer> imageUrl;
    private List<String> contentDate;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.activity_bookmall_cartoon,null);
        //初始化绑定数据
        init(view);
        //页面下拉刷新的方法
        confilct();
        //实现轮播图的方法
        newBanner();
        //点击关闭recyvleLayout
        setListener();


        return view;
    }

    //初始化绑定数据
    private void init(View view) {
        mSwipeRefreshLayout = view.findViewById(R.id.cartoon_rfw);
        mScrollView = view.findViewById(R.id.cartoon_sv);
        mBanner = view.findViewById(R.id.cartoon_title_banner);
        relativeLayout = view.findViewById(R.id.cartoon_button_silly);
        dlRecycleLayout = view.findViewById(R.id.cartoon_button_dldl);
        sillyButton = view.findViewById(R.id.cartoon_button_silly_btu);
        dlDlButton = view.findViewById(R.id.cartoon_button_dldl_btu);
    }

    //实现轮播图的方法
    private void newBanner() {
        imageUrl = new ArrayList<>();
        contentDate = new ArrayList<>();
        imageUrl.add(R.drawable.cartoon_banner1);
        imageUrl.add(R.drawable.cartoon_banner2);
        imageUrl.add(R.drawable.cartoon_banner3);
        imageUrl.add(R.drawable.cartoon_banner4);
        contentDate.add("");
        contentDate.add("");
        contentDate.add("");
        contentDate.add("");
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mBanner.setImageLoader(new MyLoader());
        mBanner.setImages(imageUrl);mBanner.setBannerAnimation(Transformer.Default);
        mBanner.setBannerTitles(contentDate);
        //播放多长时间换图
        mBanner.setDelayTime(3000);
        //是否自动启动
        mBanner.isAutoPlay(true);
        //点点位置设置
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //开始运行
        mBanner.start();
    }
    class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(getActivity()).load(path).into(imageView);
        }
    }

    // 解决滚动条和上拉刷新的冲突
    private void confilct() {
        //设置刷新的背景颜色，默认为白色
        mSwipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.colorWhite);
        //设置刷新的背景颜色
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent, R.color.colorOrange, R.color.colorPrimaryDark);
        //解决SwipeRefreshLayout与ScrollView滑动冲突
        mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                mSwipeRefreshLayout.setEnabled(mScrollView.getScrollY()==0);
            }
        });
        //设置上拉刷新的时间，时间到了，隐藏
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //模拟网络请求需要3000毫秒，请求完成，设置setRefreshing 为false
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 1200);
            }
        });
    }

    //实现监听的方法
    private void setListener(){
        BookmallCartoonFragment.OnClick onClick = new BookmallCartoonFragment.OnClick();
        sillyButton.setOnClickListener(onClick);
        dlDlButton.setOnClickListener(onClick);
    }

    //实现监听的内部类
    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                //点击关闭这个RecycleLayout毒医模块
                case R.id.cartoon_button_silly_btu:
                    relativeLayout.setVisibility(View.GONE);
                    break;
                    //点击关闭这个RecycleLayout绝世唐门模块
                case R.id.cartoon_button_dldl_btu:
                    dlRecycleLayout.setVisibility(View.GONE);
                    break;

            }
        }
    }


}
