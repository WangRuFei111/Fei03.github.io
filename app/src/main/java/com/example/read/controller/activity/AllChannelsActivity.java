package com.example.read.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.read.R;
import com.example.read.controller.adapter.AddAdapter;
import com.example.read.controller.adapter.CatAdapter;
import com.example.read.model.bean.FruitText;

import java.util.ArrayList;
import java.util.List;

public class AllChannelsActivity extends AppCompatActivity {
    private List<FruitText> mFruitCat = new ArrayList<>();
    private List<FruitText> mFruitAdd = new ArrayList<>();
    private TextView mClse;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allchannels);
        init();
        cat();
        add();
        setListeners();

    }

    //初始化控件
    private void init(){
        mClse = findViewById(R.id.tv_allchannels_fins);
    }

    //全部频道中，切换频道部分的RecycleView的方法
    private void cat(){
        RecyclerView recyclerCat = findViewById(R.id.rv_allchannels);
        StaggeredGridLayoutManager staggeredCat = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
        recyclerCat.setLayoutManager(staggeredCat);
        CatAdapter catAdapter = new CatAdapter(mFruitCat,this);
        recyclerCat.setAdapter(catAdapter);
        recyclerCat.setNestedScrollingEnabled(false);
        initCat();

    }
    //全部频道中，切换频道部分的RecycleView的填充数据的方法
    private void initCat(){
        FruitText c1 = new FruitText("精选");
        mFruitCat.add(c1);
        FruitText c2= new FruitText("女生");
        mFruitCat.add(c2);
        FruitText c3 = new FruitText("漫画");
        mFruitCat.add(c3);
        FruitText c4 = new FruitText("精品课");
        mFruitCat.add(c4);
        FruitText c5= new FruitText("出版");
        mFruitCat.add(c5);
        FruitText c6 = new FruitText("男生");
        mFruitCat.add(c6);
        FruitText c7 = new FruitText("免费");
        mFruitCat.add(c7);
        FruitText c8 = new FruitText("板栗");
        mFruitCat.add(c8);
        FruitText c9 = new FruitText("现代言情");
        mFruitCat.add(c9);

    }

    //点击添加频道的recycleview的方法
    private void add(){
        RecyclerView recyclerAdd = findViewById(R.id.add_allchannels);
        StaggeredGridLayoutManager staggeredAdd = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
        recyclerAdd.setLayoutManager(staggeredAdd);
        AddAdapter addAdapter = new AddAdapter(mFruitAdd,this);
        recyclerAdd.setAdapter(addAdapter);
        recyclerAdd.setNestedScrollingEnabled(false);
        initAdd();

    }
    //点击添加频道的recycleview的填充方法
    private void initAdd(){
        FruitText a1 = new FruitText("爱情图鉴");
        mFruitAdd.add(a1);
        FruitText a2= new FruitText("古言小说");
        mFruitAdd.add(a2);
        FruitText a3 = new FruitText("奇文");
        mFruitAdd.add(a3);
        FruitText a4 = new FruitText("玄幻");
        mFruitAdd.add(a4);
        FruitText a5= new FruitText("都市");
        mFruitAdd.add(a5);
        FruitText a6 = new FruitText("轻小说");
        mFruitAdd.add(a6);
        FruitText a7 = new FruitText("言情速看");
        mFruitAdd.add(a7);
        FruitText a8 = new FruitText("小说漫改");
        mFruitAdd.add(a8);
        FruitText a9 = new FruitText("穿越重生");
        mFruitAdd.add(a9);
        FruitText a10 = new FruitText("霸道总裁");
        mFruitAdd.add(a10);
        FruitText a11 = new FruitText("大神");
        mFruitAdd.add(a11);
        FruitText a12 = new FruitText("课外书");
        mFruitAdd.add(a12);
        FruitText a13 = new FruitText("品质阅读");
        mFruitAdd.add(a13);
        FruitText a14 = new FruitText("影视小说");
        mFruitAdd.add(a14);
    }

    //重写activity的三个方法，设置它启动进入的方式和摧毁activity的方式
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.slide_bottom_in,R.anim.silde_bottom_out);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.slide_bottom_in,R.anim.silde_bottom_out);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_bottom_in,R.anim.silde_bottom_out);
    }

    //实现单击事件的方法
    private void setListeners(){
        AllChannelsActivity.OnClick onClick = new AllChannelsActivity.OnClick();
        mClse.setOnClickListener(onClick);
    }

    //实现单击事件的内部类
    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv_allchannels_fins:
                    finish();
                    break;
            }
        }
    }


}
