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
import com.example.read.controller.adapter.BoutiqueGrilAdapter;
import com.example.read.controller.adapter.ChoicenessAdapter;
import com.example.read.controller.adapter.PopularityAdapter;
import com.example.read.model.bean.FruitImageText;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

//这是这是书架部分头部精选的布局
public class BookmallChoicenessFragmgnt extends Fragment {
    private ScrollView mScrollView;
    private Banner mBanner;
    private Button mRebirth,mInteres,mErotica;
    private List<Integer> imageUrl;
    private List<String> contentDate;
    private RelativeLayout mRelativeLayou,mInteresRelative,mEroticaRelative;
    private SwipeRefreshLayout mSwipeRefreshs;
    private List<FruitImageText> mFruitImageGirl = new ArrayList<>();
    private List<FruitImageText> mFruitImagePopularity = new ArrayList<>();
    private List<FruitImageText> mFruitImagePraise = new ArrayList<>();
    private List<FruitImageText> mFruitImageBoutique = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(),R.layout.activity_bookmall_choiceness,null);
        init(view);
        confilct();
        newBanner();
        choicenessGirl(view);
        popularity(view);
        praise(view);
        boutique(view);
        setLinstnts();
        return view;
    }

    //    初始化控件
    private void init(View view) {
        mScrollView = view.findViewById(R.id.choiceness_scrollview);
        mSwipeRefreshs = view.findViewById(R.id.bookmall_choiceness_srlayout);
        mBanner = view.findViewById(R.id.rv_banner);
        mRebirth = view.findViewById(R.id.rebirth_content_btu);
        mRelativeLayou = view.findViewById(R.id.bookmall_choicenes_rebirth);
        mInteres = view.findViewById(R.id.interest_content_btu);
        mInteresRelative=view.findViewById(R.id.bookmall_choicenes_interest);
        mErotica=view.findViewById(R.id.erotica_content_btu);
        mEroticaRelative=view.findViewById(R.id.bookmall_choicenes_erotica);
    }

    //头部轮播
    private void newBanner() {
        imageUrl = new ArrayList<>();
        contentDate = new ArrayList<>();
        imageUrl.add(R.drawable.bookmall_banner5);
        imageUrl.add(R.drawable.bookmall_banner4);
        imageUrl.add(R.drawable.bookmall_banner3);
        imageUrl.add(R.drawable.bookmall_banner2);
        imageUrl.add(R.drawable.bookmall_banner1);
        contentDate.add("");
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

    //女生畅销部分的recycle view部分
    private void choicenessGirl(View view){
        RecyclerView recyclerGirl = view.findViewById(R.id.choicenes_leading_recycleview);
        StaggeredGridLayoutManager staggeredGirl = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerGirl.setLayoutManager(staggeredGirl);
        ChoicenessAdapter choicenessAdapter = new ChoicenessAdapter(mFruitImageGirl,this);
        recyclerGirl.setAdapter(choicenessAdapter);
        recyclerGirl.setNestedScrollingEnabled(false);
        initChoicenessGirl();
    }

    //女生畅销部分的recycle view部分填充数据
    private void initChoicenessGirl(){
        FruitImageText choiceness1 = new FruitImageText("一胎双宝：总裁爹地太卖力",R.drawable.dd);
        mFruitImageGirl.add(choiceness1);
        FruitImageText choiceness2= new FruitImageText("贴身丫鬟",R.drawable.dc);
        mFruitImageGirl.add(choiceness2);
        FruitImageText choiceness3 = new FruitImageText("一胎双宝：总裁爹地惹不得",R.drawable.dr);
        mFruitImageGirl.add(choiceness3);
    }

    //女生人气部分的recycleview部分
    private void popularity(View view){
        RecyclerView recyclerPopularity = view.findViewById(R.id.choicenes_popularity_recycleview);
        StaggeredGridLayoutManager staggeredPopularity = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerPopularity.setLayoutManager(staggeredPopularity);
        PopularityAdapter popularityAdapter = new PopularityAdapter(mFruitImagePopularity,this);
        recyclerPopularity.setAdapter(popularityAdapter);
        recyclerPopularity.setNestedScrollingEnabled(false);
        initPopularity();


    }
    //女生人气部分的数据填充
    private void initPopularity(){
        FruitImageText popularity1 = new FruitImageText("摄政王爷欺上门",R.drawable.c1);
        mFruitImagePopularity.add(popularity1);
        FruitImageText popularity2= new FruitImageText("绝色玄灵师：邪君的腹黑妃",R.drawable.c2);
        mFruitImagePopularity.add(popularity2);
        FruitImageText popularity3 = new FruitImageText("总裁追妻太凶猛",R.drawable.c3);
        mFruitImagePopularity.add(popularity3);
        FruitImageText popularity4 = new FruitImageText("庶女医妃",R.drawable.c4);
        mFruitImagePopularity.add(popularity4);
        FruitImageText popularity5= new FruitImageText("炮灰女配打脸日常",R.drawable.d4);
        mFruitImagePopularity.add(popularity5);
        FruitImageText popularity6 = new FruitImageText("女配锦绣年华",R.drawable.c6);
        mFruitImagePopularity.add(popularity6);
    }

    //女生口碑
    private void praise(View view){
        RecyclerView recyclerPraise = view.findViewById(R.id.choicenes_praise_recycleview);
        StaggeredGridLayoutManager staggeredPraise = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerPraise.setLayoutManager(staggeredPraise);
        PopularityAdapter popularityAdapter = new PopularityAdapter(mFruitImagePraise,this);
        recyclerPraise.setAdapter(popularityAdapter);
        recyclerPraise.setNestedScrollingEnabled(false);
        initPraise();
    }
    //女生口碑数据填充
    private void initPraise() {
        FruitImageText praise1 = new FruitImageText("守寡失败以后",R.drawable.b1);
        mFruitImagePraise.add(praise1);
        FruitImageText praise2 = new FruitImageText("权宠嫡女：将后重生",R.drawable.b2);
        mFruitImagePraise.add(praise2);
        FruitImageText praise3 = new FruitImageText("凤求凰",R.drawable.b3);
        mFruitImagePraise.add(praise3);
        FruitImageText praise4 = new FruitImageText("八十年代只娇花",R.drawable.b4);
        mFruitImagePraise.add(praise4);
        FruitImageText praise5 = new FruitImageText("种田之流放边塞",R.drawable.b5);
        mFruitImagePraise.add(praise5);
        FruitImageText praise6 = new FruitImageText("一胎双宝：总裁套路深",R.drawable.b6);
        mFruitImagePraise.add(praise6);
        FruitImageText praise7 = new FruitImageText("天官赐福",R.drawable.d1);
        mFruitImagePraise.add(praise7);
        FruitImageText praise8 = new FruitImageText("重生成反派后妈",R.drawable.d2);
        mFruitImagePraise.add(praise8);
        FruitImageText praise9 = new FruitImageText("人渣反派自救系统",R.drawable.d3);
        mFruitImagePraise.add(praise9);

    }

    //女生精品
    private void boutique(View view){
        RecyclerView recyclerBoutique = view.findViewById(R.id.choicenes_boutique_recycleview);
        StaggeredGridLayoutManager staggeredBoutique = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerBoutique.setLayoutManager(staggeredBoutique);
        BoutiqueGrilAdapter boutiqueGrilAdapter=new BoutiqueGrilAdapter(mFruitImageBoutique,this);
        recyclerBoutique.setAdapter(boutiqueGrilAdapter);
        recyclerBoutique.setNestedScrollingEnabled(false);
        initBoutique();
    }
    //女生精品填充数据
    private void initBoutique() {
        FruitImageText boutique1 = new FruitImageText("郁先生，正经点！",R.drawable.c4);
        mFruitImageBoutique.add(boutique1);
        FruitImageText boutique2 = new FruitImageText("科举逆袭：最强女首辅",R.drawable.c5);
        mFruitImageBoutique.add(boutique2);
        FruitImageText boutique3 = new FruitImageText("宠妻入怀：重生娇妻有点甜",R.drawable.c6);
        mFruitImageBoutique.add(boutique3);
        FruitImageText boutique4 = new FruitImageText("娇宠八零",R.drawable.dd);
        mFruitImageBoutique.add(boutique4);
        FruitImageText boutique5 = new FruitImageText("太子宠妃日常",R.drawable.dr);
        mFruitImageBoutique.add(boutique5);
        FruitImageText boutique6 = new FruitImageText("容辞",R.drawable.dc);
        mFruitImageBoutique.add(boutique6);


    }

    //单击方法的实现
    private void setLinstnts(){
        BookmallChoicenessFragmgnt.OnClick onClick = new BookmallChoicenessFragmgnt.OnClick();
        mRebirth.setOnClickListener(onClick);
        mInteres.setOnClickListener(onClick);
        mErotica.setOnClickListener(onClick);

    }
    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.rebirth_content_btu:
                    mRelativeLayou.setVisibility(View.GONE);
                    break;
                case R.id.interest_content_btu:
                    mInteresRelative.setVisibility(View.GONE);
                    break;
                case R.id.erotica_content_btu:
                    mEroticaRelative.setVisibility(View.GONE);
                    break;
            }
        }
    }


}
