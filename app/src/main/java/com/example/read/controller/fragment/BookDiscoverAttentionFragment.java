package com.example.read.controller.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.read.R;
import com.example.read.controller.adapter.AttentionFragmentAdapter;
import com.example.read.model.bean.FruitImageTextTow;

import java.util.ArrayList;
import java.util.List;


//发现页面得关注页面
public class BookDiscoverAttentionFragment extends Fragment {

    private ScrollView mDbScrollView;
    private SwipeRefreshLayout mDbSwipeRefreshs;
    private List<FruitImageTextTow> mAttentionFruitImage = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.activity_bookdiscover_attention,null);
        init(view);
        initRecycleView(view);
        confilct();
        return view;

    }

    //初始化绑定布局
    private void init(View view) {
        mDbScrollView = view.findViewById(R.id.bd_att_scorollview);
        mDbSwipeRefreshs = view.findViewById(R.id.bd_att_swipefresh);
    }

    //添加关注布局得RecycleView方法
    private void initRecycleView(View view) {
        RecyclerView addRecycleView = view.findViewById(R.id.add_recycleView);
        StaggeredGridLayoutManager addMagnager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        addRecycleView.setLayoutManager(addMagnager);
        AttentionFragmentAdapter addAdapter = new AttentionFragmentAdapter(mAttentionFruitImage,BookDiscoverAttentionFragment.this);
        addRecycleView.setAdapter(addAdapter);
        addRecycleView.setNestedScrollingEnabled(false);
        initRecycleData();
    }
    //添加关注布局得数据填充
    private void initRecycleData() {
        FruitImageTextTow add1 = new FruitImageTextTow("紫霞仙子在哦","所有得暧昧都是宿命。",R.drawable.b1);
        mAttentionFruitImage.add(add1);
        FruitImageTextTow add2 = new FruitImageTextTow("尘封","青年作家，新概念全国二等奖获得者，代表作《最美是相遇，最...",R.drawable.b2);
        mAttentionFruitImage.add(add2);
        FruitImageTextTow add3 = new FruitImageTextTow("两个栗子","",R.drawable.b3);
        mAttentionFruitImage.add(add3);
        FruitImageTextTow add4 = new FruitImageTextTow("夏文学","媒体编辑，专栏作者，知名书评人。",R.drawable.b4);
        mAttentionFruitImage.add(add4);


    }
    // 解决滚动条和上拉刷新的冲突
    private void confilct() {
        //设置刷新的背景颜色，默认为白色
        mDbSwipeRefreshs.setProgressBackgroundColorSchemeResource(R.color.colorWhite);
        //设置刷新的背景颜色
        mDbSwipeRefreshs.setColorSchemeResources(R.color.colorAccent, R.color.colorOrange, R.color.colorPrimaryDark);
        //解决SwipeRefreshLayout与ScrollView滑动冲突
        mDbScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                mDbSwipeRefreshs.setEnabled(mDbScrollView.getScrollY()==0);
            }
        });
        //设置上拉刷新的时间，时间到了，隐藏
        mDbSwipeRefreshs.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //模拟网络请求需要3000毫秒，请求完成，设置setRefreshing 为false
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mDbSwipeRefreshs.setRefreshing(false);
                    }
                }, 1200);
            }
        });
    }

}
