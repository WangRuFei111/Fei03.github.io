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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.example.read.R;
import com.example.read.controller.adapter.AttentionAdapter;
import com.example.read.model.bean.FruitImage;
import com.example.read.utils.OnItemClickListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

//这是发现的首页--热门
public class BookDiscoverHotFragment extends Fragment {
    private Banner bookdiscoverBanner;
    private List<Integer> imageUrl;
    private List<String> contentDate;
    private ScrollView mScrollView;
    private SwipeRefreshLayout mSwipeRefreshs;
    private List<FruitImage> attentionList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.activity_bookdiscover_hot,null);
        init(view);
        initBanner();
        confilct();
        attention(view);

        return view;

    }

    // 热门页面中间部分第三个板块  初恋这些小事的RecycleView的方法
    private void attention(View view) {
        RecyclerView recyclerAttention = view.findViewById(R.id.recycleView_attention);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerAttention.setLayoutManager(linearLayoutManager);
        AttentionAdapter attentionAdapter = new AttentionAdapter(attentionList);
        recyclerAttention.setAdapter(attentionAdapter);
        attentionAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position){
                    case 0:
                        Toast.makeText(getContext(),"初恋这件小事",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getContext(),"向往的职业",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getContext(),"如果你是一本书",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getContext(),"感谢，你曾经带给我的感动",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getContext(),"难忘瞬间",Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(getContext(),"说出心中的恐惧",Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(getContext(),"长大是一种什么感觉",Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        Toast.makeText(getContext(),"奇葩穿越知多少",Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        Toast.makeText(getContext(),"十九岁的时光",Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        Toast.makeText(getContext(),"初恋这件小事",Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
        initAttention();
    }
    // 热门页面中间部分第三个板块  初恋这些小事的RecycleView的填充方法
    private void initAttention() {
        FruitImage img1 = new FruitImage(R.drawable.attention_img1);
        attentionList.add(img1);
        FruitImage img2 = new FruitImage(R.drawable.attention_img2);
        attentionList.add(img2);
        FruitImage img3 = new FruitImage(R.drawable.attention_img3);
        attentionList.add(img3);
        FruitImage img4 = new FruitImage(R.drawable.attention_img4);
        attentionList.add(img4);
        FruitImage img5 = new FruitImage(R.drawable.attention_img5);
        attentionList.add(img5);
        FruitImage img6 = new FruitImage(R.drawable.attention_img6);
        attentionList.add(img6);
        FruitImage img7 = new FruitImage(R.drawable.attention_img7);
        attentionList.add(img7);
        FruitImage img8 = new FruitImage(R.drawable.attention_img8);
        attentionList.add(img8);
        FruitImage img9 = new FruitImage(R.drawable.attention_img9);
        attentionList.add(img9);
        FruitImage img10 = new FruitImage(R.drawable.attention_img10);
        attentionList.add(img10);
    }

    //初始化控件绑定布局
    private void init(View view) {
        bookdiscoverBanner =view.findViewById(R.id.rv_bookdiscover_banner);
        mScrollView = view.findViewById(R.id.bookDiscover_attention_scorollview);
        mSwipeRefreshs = view.findViewById(R.id.bookDiscover_attention_swipefresh);
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
        bookdiscoverBanner.setImageLoader(new BookDiscoverHotFragment.MyLoader());
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
