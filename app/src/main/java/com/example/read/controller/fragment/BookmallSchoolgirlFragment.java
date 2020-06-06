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
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.example.read.R;
import com.example.read.controller.adapter.BoomAdapter;
import com.example.read.controller.adapter.BoutiqueAdapter;
import com.example.read.controller.adapter.LeadingAdapter;
import com.example.read.controller.adapter.ModernAdapter;
import com.example.read.controller.adapter.NewsetAdapter;
import com.example.read.model.bean.FruitImageText;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

//这是书架的标题栏中女生的布局
public class BookmallSchoolgirlFragment extends Fragment {
    private ScrollView mScrollViews;
    private SwipeRefreshLayout mSwipeRefreshLayouts;
    private Banner mBanner;
    private RelativeLayout mRelativeLayout,contemporaryLayout,villainLayout;
    private List<Integer> imageUrlDate;
    private List<String> contentData;
    private Button close,mContemporary,villainBtu;
    private List<FruitImageText> mFruitImageTexts = new ArrayList<>();
    private List<FruitImageText> mFruitImageBou = new ArrayList<>();
    private List<FruitImageText> mFruitImageBoom = new ArrayList<>();
    private List<FruitImageText> mFruitImageModern = new ArrayList<>();
    private List<FruitImageText> mFruitImageNewset = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.activity_bookmall_schoolgirl,null);
        init(view);
        realizeBanner();
        confilct();
        leading(view);
        boutiqueInit(view);
        boom(view);
        modern(view);
        newset(view);
        setListeners();

        return view;
    }

    //初始化控件
    private void init(View view) {
        mBanner = view.findViewById(R.id.schoolgirl_title_banner);
        mScrollViews = view.findViewById(R.id.bookmall_scrollview);
        mSwipeRefreshLayouts= view.findViewById(R.id.bookmall_swipe);
        close = view.findViewById(R.id.ability_content_btu);
        mRelativeLayout = view.findViewById(R.id.bookmall_schoolgirl_ability);
        mContemporary = view.findViewById(R.id.contemporary_content_btu);
        contemporaryLayout = view.findViewById(R.id.bookmall_schoolgirl_contemporary);
        villainLayout = view.findViewById(R.id.bookmall_schoolgirl_villain);
        villainBtu = view.findViewById(R.id.villain_content_btu);
    }

    //解决滚动条和上拉刷新的冲突
    private void confilct(){
        //设置刷新的背景颜色，默认为白色
        mSwipeRefreshLayouts.setProgressBackgroundColorSchemeResource(R.color.colorWhite);
        //设置刷新的背景颜色
        mSwipeRefreshLayouts.setColorSchemeResources(R.color.colorAccent, R.color.colorOrange, R.color.colorPrimaryDark);
        //解决SwipeRefreshLayout与ScrollView滑动冲突
        mScrollViews.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                mSwipeRefreshLayouts.setEnabled(mScrollViews.getScrollY()==0);
            }
        });
        //设置上拉刷新的时间，时间到了，隐藏
        mSwipeRefreshLayouts.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //模拟网络请求需要3000毫秒，请求完成，设置setRefreshing 为false
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshLayouts.setRefreshing(false);
                    }
                }, 1200);
            }
        });
    }

    //古言畅销书部分
    private void boom(View view){
        RecyclerView recyclerBoom = view.findViewById(R.id.schoolgirl_boom_recycleview);
        StaggeredGridLayoutManager staggeredBoom = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerBoom.setLayoutManager(staggeredBoom);
        BoomAdapter boomAdapter = new BoomAdapter(mFruitImageBoom,this);
        recyclerBoom.setAdapter(boomAdapter);
        recyclerBoom.setNestedScrollingEnabled(false);
        initBoom();
    }
    //古言畅销书部分的填充数据
    private void initBoom() {
        FruitImageText c1 = new FruitImageText("女配美炸天[快穿]",R.drawable.c1);
        mFruitImageBoom.add(c1);
        FruitImageText c2= new FruitImageText("嫁给前夫他哥",R.drawable.c2);
        mFruitImageBoom.add(c2);
        FruitImageText c3 = new FruitImageText("邪王嗜宠：逆天毒医大小姐",R.drawable.c3);
        mFruitImageBoom.add(c3);
        FruitImageText c4 = new FruitImageText("庶女医妃：邪王，别犯规！",R.drawable.c4);
        mFruitImageBoom.add(c4);
        FruitImageText c5= new FruitImageText("庶女毒妃",R.drawable.c5);
        mFruitImageBoom.add(c5);
        FruitImageText c6 = new FruitImageText("女配锦绣荣华",R.drawable.c6);
        mFruitImageBoom.add(c6);
    }

    //最新古言部分
    private void newset(View view){
        RecyclerView recyclerNewsets = view.findViewById(R.id.schoolgirl_newset_recycleview);
        StaggeredGridLayoutManager staggeredNewset = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerNewsets.setLayoutManager(staggeredNewset);
        NewsetAdapter newsetAdapter = new NewsetAdapter(mFruitImageNewset,this);
        recyclerNewsets.setAdapter(newsetAdapter);
        recyclerNewsets.setNestedScrollingEnabled(false);
        initNewset();
    }
    //最新古言部分填充数据
    private void initNewset() {
        FruitImageText d1 = new FruitImageText("农家一品食神妻",R.drawable.b1);
        mFruitImageNewset.add(d1);
        FruitImageText d2= new FruitImageText("将军，夫人又爬墙了",R.drawable.b2);
        mFruitImageNewset.add(d2);
        FruitImageText d3 = new FruitImageText("小皇后",R.drawable.c3);
        mFruitImageNewset.add(d3);
        FruitImageText d4 = new FruitImageText("庶女医妃：邪王，别犯规！",R.drawable.c4);
        mFruitImageNewset.add(d4);
        FruitImageText d5= new FruitImageText("庶女毒妃",R.drawable.c5);
        mFruitImageNewset.add(d5);
        FruitImageText d6 = new FruitImageText("女配锦绣荣华",R.drawable.c6);
        mFruitImageNewset.add(d6);
    }

    //本期精品的瀑布流格式
    private void boutiqueInit(View view){
        RecyclerView recyclerBou = view.findViewById(R.id.schoolgirl_boutique_recycleview);
        StaggeredGridLayoutManager staggeredGridBou = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerBou.setLayoutManager(staggeredGridBou);
        BoutiqueAdapter boutiqueAdapter = new BoutiqueAdapter(mFruitImageBou,this);
        recyclerBou.setAdapter(boutiqueAdapter);
        recyclerBou.setNestedScrollingEnabled(false);
        initboutique();
    }
    //本期精品的数据填充
    private void initboutique() {
        FruitImageText b1 = new FruitImageText("诱宠再婚：前夫，晚上来",R.drawable.b1);
        mFruitImageBou.add(b1);
        FruitImageText b2= new FruitImageText("七零年代过好日子",R.drawable.b2);
        mFruitImageBou.add(b2);
        FruitImageText b3 = new FruitImageText("天仙赐孕：皇上，快躺下！",R.drawable.b3);
        mFruitImageBou.add(b3);
        FruitImageText b4 = new FruitImageText("穿成残疾大佬的冲喜新娘",R.drawable.b4);
        mFruitImageBou.add(b4);
        FruitImageText b5= new FruitImageText("我妻福星高照",R.drawable.b5);
        mFruitImageBou.add(b5);
        FruitImageText b6 = new FruitImageText("谈恋爱不如上清华",R.drawable.b6);
        mFruitImageBou.add(b6);
    }

    //本期主打的瀑布流格式
    private void leading(View view){
        RecyclerView recyclerView =view.findViewById(R.id.schoolgirl_leading_recycleview);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        LeadingAdapter leadingAdapter = new LeadingAdapter(mFruitImageTexts,this);
        recyclerView.setAdapter(leadingAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        initLeading();
    }
    //本期主打的瀑布流格式的填充内容
    private void initLeading(){
        FruitImageText a1 = new FruitImageText("女配想开了",R.drawable.leading1);
        mFruitImageTexts.add(a1);
        FruitImageText a2= new FruitImageText("好运连连：总裁爹爹霸道宠",R.drawable.leading2);
        mFruitImageTexts.add(a2);
        FruitImageText a3 = new FruitImageText("农门悍妻：夫君好磨人",R.drawable.leading3);
        mFruitImageTexts.add(a3);
    }

    //现言畅销部分
    private void modern(View view){
        RecyclerView recyclerMdern = view.findViewById(R.id.schoolgirl_modern_recycleview);
        StaggeredGridLayoutManager staggeredModern = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerMdern.setLayoutManager(staggeredModern);
        ModernAdapter modernAdapter = new ModernAdapter(mFruitImageModern,this);
        recyclerMdern.setAdapter(modernAdapter);
        recyclerMdern.setNestedScrollingEnabled(false);
        initModern();
    }
    //现言畅销部分的填充数据
    private void initModern() {
        FruitImageText b1 = new FruitImageText("枕上燃情：小妻吻上瘾",R.drawable.d1);
        mFruitImageModern.add(b1);
        FruitImageText b2= new FruitImageText("龙凤双宝：特工妈咪要翻天",R.drawable.d2);
        mFruitImageModern.add(b2);
        FruitImageText b3 = new FruitImageText("叔，你金屋藏娇啊！",R.drawable.d3);
        mFruitImageModern.add(b3);
        FruitImageText b4 = new FruitImageText("重回七零：炮灰女配打脸日常",R.drawable.d4);
        mFruitImageModern.add(b4);
        FruitImageText b5= new FruitImageText("七十年代喜当妈",R.drawable.d5);
        mFruitImageModern.add(b5);
        FruitImageText b6 = new FruitImageText("小妻在上：总裁，你乖点",R.drawable.d6);
        mFruitImageModern.add(b6);
    }


    //实现头部轮播图的方法
    private void realizeBanner(){
        imageUrlDate = new ArrayList<>();
        contentData = new ArrayList<>();
        imageUrlDate.add(R.drawable.bookmall_banner1);
        imageUrlDate.add(R.drawable.bookmall_banner2);
        imageUrlDate.add(R.drawable.bookmall_banner3);
        imageUrlDate.add(R.drawable.bookmall_banner4);
        imageUrlDate.add(R.drawable.bookmall_banner5);
        imageUrlDate.add(R.drawable.bookmall_banner6);
        contentData.add("");
        contentData.add("");
        contentData.add("");
        contentData.add("");
        contentData.add("");
        contentData.add("");
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mBanner.setImageLoader(new BookmallSchoolgirlFragment.MyLoader());
        mBanner.setImages(imageUrlDate);
        mBanner.setBannerTitles(contentData);
        mBanner.setBannerAnimation(Transformer.Default);
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

    //当返回到activity，继续使用轮播
    public void onResume() {
        super.onResume();
        mBanner.start();
    }
    //当activity摧毁，停止运行
    public void onStop() {
        super.onStop();
        mBanner.stopAutoPlay();
    }

    //实现监听的方法
   private void setListeners(){
        BookmallSchoolgirlFragment.OnClick onClick = new BookmallSchoolgirlFragment.OnClick();
        close.setOnClickListener(onClick);
        mContemporary.setOnClickListener(onClick);
        villainBtu.setOnClickListener(onClick);
    }

    //实现监听的内部类
    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                //点击关闭这个RecycleLayout推荐模块
                case R.id.ability_content_btu:
                    mRelativeLayout.setVisibility(View.GONE);
                    break;
//                    点击关闭这个RecycleLayout推荐模块布局
                case R.id.contemporary_content_btu:
                    contemporaryLayout.setVisibility(View.GONE);
                    break;
                //点击关闭这个RecycleLayout推荐模块
                case R.id.villain_content_btu:
                    villainLayout.setVisibility(View.GONE);
                    break;
            }
        }
    }



}
