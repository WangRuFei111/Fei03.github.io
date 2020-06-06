package com.example.read.controller.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.read.R;
import com.example.read.controller.adapter.ClassificationAdapter;
import com.example.read.controller.fragment.ClassificationAppearFragment;
import com.example.read.controller.fragment.ClassificationHorsewomanFragment;
import com.example.read.controller.fragment.ClassificationIbidemFragment;
import com.example.read.model.bean.FruitText;
import com.example.read.utils.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

//从书城跳转到分类页面
public class ClassificationActivity extends AppCompatActivity {
    private List<FruitText> fruitListCl = new ArrayList<>();
    private ImageView fishImg;
    //当前显示的fragment
    private static final String CURRENT_FRAGMENT = "STATE_FRAGMENT_SHOW";
    private FragmentManager fragmentManagerClass;
    private Fragment currentFragmentClass = new Fragment();
    private List<Fragment> fragmentsClass = new ArrayList<>();
    private int currentIndexClass = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification);
        fragmentManagerClass =this.getSupportFragmentManager();
        if (savedInstanceState != null) { // “内存重启”时调用

            //获取“内存重启”时保存的索引下标
            currentIndexClass = savedInstanceState.getInt(CURRENT_FRAGMENT,0);

            //注意，添加顺序要跟下面添加的顺序一样！！！！
            fragmentsClass.removeAll(fragmentsClass);
            fragmentsClass.add(fragmentManagerClass.findFragmentByTag(0+""));
            fragmentsClass.add(fragmentManagerClass.findFragmentByTag(1+""));
            fragmentsClass.add(fragmentManagerClass.findFragmentByTag(2+""));

            //恢复fragment页面
            restoreFragment();


        }else{      //正常启动时调用

            fragmentsClass.add(new ClassificationHorsewomanFragment());
            fragmentsClass.add(new ClassificationAppearFragment());
            fragmentsClass.add(new ClassificationIbidemFragment());

            showFragment();
        }

        init();
        classificationTitle();
        setListener();
    }

    //初始化数据
    private void init() {
        fishImg = findViewById(R.id.classifi_title_img);
    }

    //分类左边的RecycleView标题的方法
    private void classificationTitle(){
        RecyclerView recyclerTitle = findViewById(R.id.classification_left_recycleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerTitle.setLayoutManager(linearLayoutManager);
        final ClassificationAdapter classificationAdapter = new ClassificationAdapter(fruitListCl);
        recyclerTitle.setAdapter(classificationAdapter);
        initClassificationTitle();

        //RecyclerView的单击事件
        classificationAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position) {
                    case 0:
                        currentIndexClass = 0;
                        classificationAdapter.setmPosition(position);
                        classificationAdapter.notifyDataSetChanged();
                        break;
                    case 1:
                        currentIndexClass = 1;
                        classificationAdapter.setmPosition(position);
                        classificationAdapter.notifyDataSetChanged();
                        break;
                    case 2:
                        currentIndexClass = 2;
                        classificationAdapter.setmPosition(position);
                        classificationAdapter.notifyDataSetChanged();
                        break;
                    case 3:
                        currentIndexClass = 0;
                        classificationAdapter.setmPosition(position);
                        classificationAdapter.notifyDataSetChanged();
                        break;
                    case 4:
                        currentIndexClass = 1;
                        classificationAdapter.setmPosition(position);
                        classificationAdapter.notifyDataSetChanged();
                        break;
                    case 5:
                        currentIndexClass = 2;
                        classificationAdapter.setmPosition(position);
                        classificationAdapter.notifyDataSetChanged();
                        break;

                }
                //实现fragment切换
                showFragment();
            }

        });
    }
    //分类左边的RecycleView填充标题的方法
    private void initClassificationTitle(){
        FruitText f1 = new FruitText("女频");
        fruitListCl.add(f1);
        FruitText f2 = new FruitText("出版");
        fruitListCl.add(f2);
        FruitText f3 = new FruitText("听书");
        fruitListCl.add(f3);
        FruitText f4 = new FruitText("男频");
        fruitListCl.add(f4);
        FruitText f5 = new FruitText("漫画");
        fruitListCl.add(f5);
        FruitText f6 = new FruitText("杂志");
        fruitListCl.add(f6);

    }

    // 单击的实现方法
    private void setListener(){
        ClassificationActivity.Onclick onclick = new ClassificationActivity.Onclick();
        fishImg.setOnClickListener(onclick);
    }

    //内部类实现单击
    class Onclick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                //点击退出
                case R.id.classifi_title_img:
                    finish();
                    break;
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        //“内存重启”时保存当前的fragment名字
        outState.putInt(CURRENT_FRAGMENT,currentIndexClass);
        super.onSaveInstanceState(outState);
    }
    /**
     * 使用show() hide()切换页面
     * 显示fragment
     */
    private void showFragment(){

        FragmentTransaction transactionClass = fragmentManagerClass.beginTransaction();

        //如果之前没有添加过
        if(!fragmentsClass.get(currentIndexClass).isAdded()){
            transactionClass
                    .hide(currentFragmentClass)
                    .add(R.id.classification_right_fragment,fragmentsClass.get(currentIndexClass),""+currentIndexClass);  //第三个参数为添加当前的fragment时绑定一个tag

        }else{
            transactionClass
                    .hide(currentFragmentClass)
                    .show(fragmentsClass.get(currentIndexClass));
        }

        currentFragmentClass = fragmentsClass.get(currentIndexClass);

        transactionClass.commit();

    }

    /**
     * 恢复fragment
     */
    private void restoreFragment(){


        FragmentTransaction mBeginTreansaction = fragmentManagerClass.beginTransaction();

        for (int i = 0; i < fragmentsClass.size(); i++) {

            if(i == currentIndexClass){
                mBeginTreansaction.show(fragmentsClass.get(i));
            }else{
                mBeginTreansaction.hide(fragmentsClass.get(i));
            }

        }

        mBeginTreansaction.commit();

        //把当前显示的fragment记录下来
        currentFragmentClass = fragmentsClass.get(currentIndexClass);

    }

}
