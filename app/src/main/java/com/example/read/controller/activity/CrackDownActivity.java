package com.example.read.controller.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.read.R;
import com.example.read.controller.adapter.CrackNowAdapter;
import com.example.read.model.bean.FruitImageTextTow;

import java.util.ArrayList;
import java.util.List;

//主页面中的 这不是真的女主页面
public class CrackDownActivity extends AppCompatActivity {
    private ImageView clean;

    private List<FruitImageTextTow> mFruitImageNow = new ArrayList<>();
    private List<FruitImageTextTow> mFruitImageTow = new ArrayList<>();
    private List<FruitImageTextTow> mFruitImageThree = new ArrayList<>();
    private List<FruitImageTextTow> mFruitImageFour = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crack_down);
        init();
        carckContentNow();
        carckContentTow();
        carckContentThree();
        carckContentFour();
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //初始化绑定布局
    private void init() {
    clean = findViewById(R.id.crack_title_img);
    }

    //第一锤：戏精女配要逆袭RecycleView的方法
    private void carckContentNow(){
        RecyclerView recycleViewNow = findViewById(R.id.carck_content_recycleview);
        StaggeredGridLayoutManager nowLayoutManager = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);
        recycleViewNow.setLayoutManager(nowLayoutManager);
        CrackNowAdapter crackNowAdapter = new CrackNowAdapter(mFruitImageNow,this);
        recycleViewNow.setAdapter(crackNowAdapter);
        recycleViewNow.setNestedScrollingEnabled(false);
        initCarckContentNow();
    }
    //第一锤：戏精女配要逆袭填充RecycleView数据的方法
    private void initCarckContentNow() {
        FruitImageTextTow now1 = new FruitImageTextTow("女配不掺和","风流书呆",R.drawable.b1);
        mFruitImageNow.add(now1);
        FruitImageTextTow now2 = new FruitImageTextTow("女配总在变美","清嘉观流",R.drawable.b2);
        mFruitImageNow.add(now2);
        FruitImageTextTow now3 = new FruitImageTextTow("女配不想死(快穿)","缘归怡",R.drawable.b3);
        mFruitImageNow.add(now3);
        FruitImageTextTow now4 = new FruitImageTextTow("戏精女配","池陌",R.drawable.b4);
        mFruitImageNow.add(now4);
        FruitImageTextTow now5 = new FruitImageTextTow("当女配成为团宠","时星草",R.drawable.b5);
        mFruitImageNow.add(now5);
        FruitImageTextTow now6 = new FruitImageTextTow("女配锦绣荣华","陈云香",R.drawable.b6);
        mFruitImageNow.add(now6);



    }

    //第二锤：干掉那个假女主RecycleView的方法
    private void carckContentTow(){
        RecyclerView recyclerViewTow = findViewById(R.id.carck_tow_recycleview);
        StaggeredGridLayoutManager towLayoutManager = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerViewTow.setLayoutManager(towLayoutManager);
        CrackNowAdapter crackTowAdapter = new CrackNowAdapter(mFruitImageTow,this);
        recyclerViewTow.setAdapter(crackTowAdapter);
        recyclerViewTow.setNestedScrollingEnabled(false);
        initCarckContentTow();
    }
    //第二锤：干掉那个假女主填充RecycleView数据的方法
    private void initCarckContentTow(){
        FruitImageTextTow tow1 = new FruitImageTextTow("女配替身：摄政王的心尖宠","小财迷",R.drawable.c1);
        mFruitImageTow.add(tow1);
        FruitImageTextTow tow2 = new FruitImageTextTow("快穿之戏精女配上线了","酒小鱼",R.drawable.c2);
        mFruitImageTow.add(tow2);
        FruitImageTextTow tow3 = new FruitImageTextTow("论恶毒女配的自我修养！","春虫虫",R.drawable.c3);
        mFruitImageTow.add(tow3);
        FruitImageTextTow tow4 = new FruitImageTextTow("彪悍女票：本宫不是白莲花","锦兰依旧",R.drawable.c4);
        mFruitImageTow.add(tow4);
        FruitImageTextTow tow5 = new FruitImageTextTow("炮灰女配逆袭了","金子姐姐",R.drawable.c5);
        mFruitImageTow.add(tow5);
        FruitImageTextTow tow6 = new FruitImageTextTow("快穿之女配她美颜盛世","醉柒",R.drawable.c6);
        mFruitImageTow.add(tow6);

    }

    //第三锤：替身战胜白月光RecycleView的方法
    private void carckContentThree(){
        RecyclerView recyclerViewThree = findViewById(R.id.carck_three_recycleview);
        StaggeredGridLayoutManager threeLayoutManager = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerViewThree.setLayoutManager(threeLayoutManager);
        CrackNowAdapter crackThreeAdapter = new CrackNowAdapter(mFruitImageThree,this);
        recyclerViewThree.setAdapter(crackThreeAdapter);
        recyclerViewThree.setNestedScrollingEnabled(false);
        initCarckContentThree();
    }
    //第三锤：替身战胜白月光RecycleView的数据填充方法
    private void initCarckContentThree() {
        FruitImageTextTow three1 = new FruitImageTextTow("先婚后爱，历少的神秘哑妻","砂糖",R.drawable.d1);
        mFruitImageThree.add(three1);
        FruitImageTextTow three2 = new FruitImageTextTow("名门私宠：霸道总裁轻轻宠","小揽竹",R.drawable.d2);
        mFruitImageThree.add(three2);
        FruitImageTextTow three3 = new FruitImageTextTow("一夜蜜婚：神秘老公宠入怀","顾十枝",R.drawable.d3);
        mFruitImageThree.add(three3);
        FruitImageTextTow three4 = new FruitImageTextTow("萌宝成双：霍少的大牌娇妻","棉朵朵",R.drawable.d4);
        mFruitImageThree.add(three4);
        FruitImageTextTow three5 = new FruitImageTextTow("缠绵入骨：宝贝，宠你上瘾","木木林",R.drawable.d5);
        mFruitImageThree.add(three5);
        FruitImageTextTow three6 = new FruitImageTextTow("穿成总裁的前女友","九紫",R.drawable.d6);
        mFruitImageThree.add(three6);
    }

    //第四锤：我家新娘被掉包RecycleView的方法
    private void carckContentFour(){
        RecyclerView recyclerViewFour = findViewById(R.id.carck_four_recycleview);
        StaggeredGridLayoutManager fourLayoutManager = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerViewFour.setLayoutManager(fourLayoutManager);
        CrackNowAdapter crackFourAdapter = new CrackNowAdapter(mFruitImageFour,this);
        recyclerViewFour.setAdapter(crackFourAdapter);
        recyclerViewFour.setNestedScrollingEnabled(false);
        initCarckContentFour();
    }
    //第四锤：我家新娘被掉包RecycleView的数据填充方法
    private void initCarckContentFour() {
        FruitImageTextTow four1 = new FruitImageTextTow("替嫁谋爱：医妻要离婚","桃丽丝",R.drawable.dc);
        mFruitImageFour.add(four1);
        FruitImageTextTow four2 = new FruitImageTextTow("偏执总裁替假妻","拈花拂柳",R.drawable.dr);
        mFruitImageFour.add(four2);
        FruitImageTextTow four3 = new FruitImageTextTow("替嫁甜婚：老公，吻安","何安笙",R.drawable.b1);
        mFruitImageFour.add(four3);
        FruitImageTextTow four4 = new FruitImageTextTow("傅总的替嫁娇妻","初城",R.drawable.b2);
        mFruitImageFour.add(four4);
        FruitImageTextTow four5 = new FruitImageTextTow("替嫁嫡妻：太子滚开","方圆",R.drawable.b3);
        mFruitImageFour.add(four5);
        FruitImageTextTow four6 = new FruitImageTextTow("闪婚有喜：恶魔总裁的替假妻","云中野鹤·",R.drawable.b4);
        mFruitImageFour.add(four6);
    }


}
