package com.example.read.controller.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.read.R;
import com.example.read.controller.adapter.AddAttentionAdapter;
import com.example.read.controller.adapter.CrackNowAdapter;
import com.example.read.model.bean.FruitImageTextTow;

import java.util.ArrayList;
import java.util.List;

import static androidx.recyclerview.widget.LinearLayoutManager.VERTICAL;

//发现页面————添加好友页面
public class AddAttentionActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView addClece;
    private List<FruitImageTextTow> mAddFruitImage = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attention);
        addClece = findViewById(R.id.add_toolber_img);
        addClece.setOnClickListener(this);
        initRecycleView();
    }

    //添加关注布局得RecycleView方法
    private void initRecycleView() {
        RecyclerView addRecycleView = findViewById(R.id.add_recycleView);
        StaggeredGridLayoutManager addMagnager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        addRecycleView.setLayoutManager(addMagnager);
        AddAttentionAdapter addAdapter = new AddAttentionAdapter(mAddFruitImage,this);
        addRecycleView.setAdapter(addAdapter);
        addRecycleView.setNestedScrollingEnabled(false);
        initRecycleData();
    }
    //添加关注布局得数据填充
    private void initRecycleData() {
        FruitImageTextTow add1 = new FruitImageTextTow("紫霞仙子在哦","所有得暧昧都是宿命。",R.drawable.b1);
        mAddFruitImage.add(add1);
        FruitImageTextTow add2 = new FruitImageTextTow("尘封","青年作家，新概念全国二等奖获得者，代表作《最美是相遇，最...",R.drawable.b2);
        mAddFruitImage.add(add2);
        FruitImageTextTow add3 = new FruitImageTextTow("两个栗子","看书，写作，比较宅。",R.drawable.b3);
        mAddFruitImage.add(add3);
        FruitImageTextTow add4 = new FruitImageTextTow("夏文学","媒体编辑，专栏作者，知名书评人。",R.drawable.b4);
        mAddFruitImage.add(add4);
        FruitImageTextTow add5 = new FruitImageTextTow("安迪斯晨风","不会写小说的小说爱好者~",R.drawable.b5);
        mAddFruitImage.add(add5);
        FruitImageTextTow add6 = new FruitImageTextTow("漠妍轩","",R.drawable.b6);
        mAddFruitImage.add(add6);
        FruitImageTextTow add7 = new FruitImageTextTow("轻阅读","党我们给知识以款待，它也会还我们以丰盛！",R.drawable.b1);
        mAddFruitImage.add(add7);
        FruitImageTextTow add8 = new FruitImageTextTow("青柠故事坊","青柠故事坊，分享最纯粹的爱恋。",R.drawable.b2);
        mAddFruitImage.add(add8);
        FruitImageTextTow add9 = new FruitImageTextTow("两个栗子","看书，写作，比较宅。",R.drawable.b3);
        mAddFruitImage.add(add9);
        FruitImageTextTow add10 = new FruitImageTextTow("紫霞仙子在哦","所有得暧昧都是宿命。",R.drawable.b1);
        mAddFruitImage.add(add10);
        FruitImageTextTow add11 = new FruitImageTextTow("紫霞仙子在哦","所有得暧昧都是宿命。",R.drawable.b1);
        mAddFruitImage.add(add11);
        FruitImageTextTow add12 = new FruitImageTextTow("尘封","青年作家，新概念全国二等奖获得者，代表作《最美是相遇，最...",R.drawable.b2);
        mAddFruitImage.add(add12);
        FruitImageTextTow add13 = new FruitImageTextTow("两个栗子","看书，写作，比较宅。",R.drawable.b3);
        mAddFruitImage.add(add13);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_toolber_img:
                finish();
                break;
        }
    }
}
