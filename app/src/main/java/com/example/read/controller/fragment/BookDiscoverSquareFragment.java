package com.example.read.controller.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.read.R;
import com.example.read.controller.adapter.CardFragmentPagerAdapter;
import com.example.read.utils.ShadowTransformer;
import com.example.read.controller.adapter.CircleAdapter;
import com.example.read.model.bean.FruitImage;
import com.example.read.utils.OnItemClickListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

// 发现页面的广场
public class BookDiscoverSquareFragment extends Fragment implements View.OnClickListener {

    private Banner bookdiscoverBanner;
    private List<Integer> imageUrl;
    private List<String> contentDate;
    private ScrollView mScrollView;
    private SwipeRefreshLayout mSwipeRefreshs;
    private List<FruitImage> circleList = new ArrayList<>();
    private ViewPager mViewPager;

    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.activity_bookdiscover_square,null);
        init(view);
        initBanner();
        confilct();
        circle(view);
        initCard(view);
        return view;
    }

    // 广场最下面的CardView+ViewPager
    private void initCard(View view) {
        mFragmentCardAdapter = new CardFragmentPagerAdapter(getChildFragmentManager(),
                dpToPixels(2, getContext()));
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);
        mViewPager.setAdapter(mFragmentCardAdapter);
        mViewPager.setPageTransformer(false, mFragmentCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(5);
        mFragmentCardShadowTransformer.enableScaling(true);
    }


    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }


    //单击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }


    //热门圈子部分的RecycleView部分
    private void circle(View view) {
        RecyclerView recyclerCircle = view.findViewById(R.id.square_circle_recycelView);
        StaggeredGridLayoutManager staggeredGridCricle = new StaggeredGridLayoutManager(
                5,StaggeredGridLayoutManager.VERTICAL);
        recyclerCircle.setLayoutManager(staggeredGridCricle);
        CircleAdapter attention = new CircleAdapter(circleList);
        recyclerCircle.setAdapter(attention);
        attention.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position){
                    case 0:
                        Toast.makeText(getActivity(),"小i书圈",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getActivity(),"古代言情",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getActivity(),"现代言情",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getActivity(),"你好，吃货",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getActivity(),"二次元",Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(getActivity(),"星座运势",Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(getActivity(),"青春校园",Toast.LENGTH_SHORT).show();
                        break;
                     case 7:
                        Toast.makeText(getActivity(),"励志与成功",Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        Toast.makeText(getActivity(),"小树洞",Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        Toast.makeText(getActivity(),"跳转到全部选择页面",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        initCircle();
    }
    //数据填充
    private void initCircle(){
        FruitImage circle1 = new FruitImage(R.drawable.circle_img1);
        circleList.add(circle1);
        FruitImage circle2 = new FruitImage(R.drawable.circle_img2);
        circleList.add(circle2);
        FruitImage circle3 = new FruitImage(R.drawable.circle_img3);
        circleList.add(circle3);
        FruitImage circle4 = new FruitImage(R.drawable.circle_img4);
        circleList.add(circle4);
        FruitImage circle5 = new FruitImage(R.drawable.circle_img5);
        circleList.add(circle5);
        FruitImage circle6 = new FruitImage(R.drawable.circle_img6);
        circleList.add(circle6);
        FruitImage circle7 = new FruitImage(R.drawable.circle_img7);
        circleList.add(circle7);
        FruitImage circle8 = new FruitImage(R.drawable.circle_img8);
        circleList.add(circle8);
        FruitImage circle9 = new FruitImage(R.drawable.circle_img9);
        circleList.add(circle9);
        FruitImage circle10 = new FruitImage(R.drawable.circle_img10);
        circleList.add(circle10);

    }

    //初始化控件绑定布局
    private void init(View view) {
        bookdiscoverBanner =view.findViewById(R.id.square_bookdiscover_banner);
        mScrollView = view.findViewById(R.id.bookDiscover_square_scorollview);
        mSwipeRefreshs = view.findViewById(R.id.bookDiscover_square_swipefresh);
        mViewPager = view.findViewById(R.id.viewPager);
    }

    //头部轮播实现方法
    private void initBanner(){
        imageUrl = new ArrayList<>();
        contentDate = new ArrayList<>();
        imageUrl.add(R.drawable.bookdiscover_banner1);
        imageUrl.add(R.drawable.bookdiscover_banner2);
        imageUrl.add(R.drawable.bookdiscover_banner3);
        imageUrl.add(R.drawable.bookdiscover_banner4);
        contentDate.add("");
        contentDate.add("");
        contentDate.add("");
        contentDate.add("");
        bookdiscoverBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        bookdiscoverBanner.setImageLoader(new BookDiscoverSquareFragment.MyLoader());
        bookdiscoverBanner.setImages(imageUrl);
        bookdiscoverBanner.setBannerAnimation(Transformer.Default);
        bookdiscoverBanner.setBannerTitles(contentDate);
        //播放多长时间换图
        bookdiscoverBanner.setDelayTime(3000);
        //是否自动启动
        bookdiscoverBanner.isAutoPlay(true);
        //点点位置设置
        bookdiscoverBanner.setIndicatorGravity(BannerConfig.CENTER);
        //开始运行
        bookdiscoverBanner.start();
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
        mSwipeRefreshs.setProgressBackgroundColorSchemeResource(R.color.colorWhite);
        //设置刷新的背景颜色
        mSwipeRefreshs.setColorSchemeResources(R.color.colorAccent, R.color.colorOrange, R.color.colorPrimaryDark);
        //解决SwipeRefreshLayout与ScrollView滑动冲突
        mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                mSwipeRefreshs.setEnabled(mScrollView.getScrollY()==0);
            }
        });
        //设置上拉刷新的时间，时间到了，隐藏
        mSwipeRefreshs.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //模拟网络请求需要3000毫秒，请求完成，设置setRefreshing 为false
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshs.setRefreshing(false);
                    }
                }, 1200);
            }
        });
    }

}
