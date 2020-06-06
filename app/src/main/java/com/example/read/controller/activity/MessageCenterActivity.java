package com.example.read.controller.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.read.R;
import com.example.read.controller.fragment.MessageEventsFragment;
import com.example.read.controller.fragment.MessageInformFragment;
import com.example.read.controller.fragment.MessageRemindFragment;
import com.example.read.utils.HomeFragmentVPFragmentAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

// 消息中心
public class MessageCenterActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mClean,mRead;
    private ViewPager mViewPagerContent;
    private TabLayout mTavLayoutTiele;
    private ArrayList<String> listtitle = new ArrayList<>();
    private ArrayList<Fragment> listfragments = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_center);
        init();
        initPager();
    }

    // 初始化布局
    private void init() {
        mClean = findViewById(R.id.message_center_clean);
        mRead = findViewById(R.id.message_center_read);
        mRead.setOnClickListener(this);
        mClean.setOnClickListener(this);
    }

    // TabLayout和VierPager的组合
    private void initPager(){
        mViewPagerContent = findViewById(R.id.message_center_viewPager);
        mTavLayoutTiele = findViewById(R.id.message_center_tabLayout);
        listtitle.add("提醒");
        listtitle.add("通知");
        listtitle.add("活动");
        //遍历 listtitle 集合 将title 添加进 TabLayou中
        for (int i = 0;i< listtitle.size();i++){
            mTavLayoutTiele.addTab(mTavLayoutTiele.newTab().setText(listtitle.get(i)));
        }
        // 将消息中心页面中的各个板块添加进去
        MessageRemindFragment remindFragment = new MessageRemindFragment();// 消息板块
        MessageInformFragment informFragment = new MessageInformFragment();// 通知板块
        MessageEventsFragment eventsFragment = new MessageEventsFragment();// 活动板块
        listfragments.add(remindFragment);
        listfragments.add(informFragment);
        listfragments.add(eventsFragment);
        HomeFragmentVPFragmentAdapter mAdapter = new HomeFragmentVPFragmentAdapter(getSupportFragmentManager(),listfragments,listtitle);
        //给ViewPager设置适配器
        mViewPagerContent.setAdapter(mAdapter);
        //将TabLayout和ViewPager关联起来。
        mTavLayoutTiele.setupWithViewPager(mViewPagerContent);
        //给TabLayout设置适配器
        mTavLayoutTiele.setTabsFromPagerAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v !=null){
            switch (v.getId()){
                case R.id.message_center_clean:
                    finish();
                    break;
                case R.id.message_center_read:
                    tipDialog();
                    break;
            }
        }
    }

    // 消息中心的右上角的全部已读点击弹出对话框
    private void tipDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("温馨提示")
                .setMessage("将所有消息标记为已读？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MessageCenterActivity.this, "你点击了确定", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MessageCenterActivity.this, "你点击了取消", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
         builder.show();
    }


}
