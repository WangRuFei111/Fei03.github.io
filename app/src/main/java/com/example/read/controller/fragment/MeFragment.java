package com.example.read.controller.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.read.R;
import com.example.read.controller.activity.CheckInActivity;
import com.example.read.controller.activity.LoginActivity;
import com.example.read.controller.activity.MessageCenterActivity;
import com.example.read.controller.activity.MyAccountActivity;
import com.example.read.controller.activity.MyBookListActivity;
import com.example.read.controller.activity.MyVIPActivity;
import com.example.read.controller.activity.SeetingActivity;
import com.example.read.controller.activity.SigninActivity;
import com.example.read.controller.adapter.MeAdapter;
import com.example.read.model.bean.FruitImageText;
import com.example.read.utils.Invisible;
import com.example.read.utils.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MeFragment extends Fragment implements View.OnClickListener{
    private LinearLayout me_zh,me_sj,me_sd,me_hd;
    private RelativeLayout btu_login;
    private List<FruitImageText> meVip = new ArrayList<>();
    private List<FruitImageText> meSignin = new ArrayList<>();
    private List<FruitImageText> meBookClub = new ArrayList<>();
    private List<FruitImageText> meSet = new ArrayList<>();
    private TextView meName;
    private ImageView mAlarm;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.activity_main_bookme,null);
        init(view);
        vip(view);
        signin(view);
        bookClub(view);
        set(view);
        return view;
    }

    // 我的VIP和我的卡券部分
    private void vip(View view) {
        RecyclerView recyclerVip = view.findViewById(R.id.rv_main_kq);
        LinearLayoutManager linearVip = new LinearLayoutManager(getActivity());
        linearVip.setOrientation(RecyclerView.VERTICAL);
        recyclerVip.setLayoutManager(linearVip);
        MeAdapter meAdapter = new MeAdapter(meVip);
        recyclerVip.setAdapter(meAdapter);
        meAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = null;
                switch (position){
                    // 我的VIP
                    case 0:
                        if(Invisible.invisible){
                            intent = new Intent(getActivity(),MyVIPActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(getActivity(),"您还未登陆，请您先登陆！",Toast.LENGTH_SHORT).show();
                            intent = new Intent(getActivity(),LoginActivity.class);
                            startActivity(intent);
                        }
                        break;
                    case 1:
                        Toast.makeText(getActivity(),"我的卡券",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        initVip();
    }
    // 我的VIP和我的卡券部分的填充数据
    private void initVip() {
        FruitImageText vip1 = new FruitImageText("我的VIP",R.drawable.me_vip);
        meVip.add(vip1);
        FruitImageText vip2 = new FruitImageText("我的卡券",R.drawable.me_kaq);
        meVip.add(vip2);
    }

    // 签到 今日免费 领红包部分
    private void signin(View view){
        RecyclerView recyclerSignin = view.findViewById(R.id.rv_main_qd);
        LinearLayoutManager linearSignin = new LinearLayoutManager(getActivity());
        linearSignin.setOrientation(RecyclerView.VERTICAL);
        recyclerSignin.setLayoutManager(linearSignin);
        MeAdapter meAdapterSignin = new MeAdapter(meSignin);
        recyclerSignin.setAdapter(meAdapterSignin);
        meAdapterSignin.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position){
                    case 0:
                        Toast.makeText(getActivity(),"领锦鲤红包，手慢无",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getActivity(),"今日免费",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Intent intent = new Intent(getActivity(), CheckInActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
        initSignin();
    }
    // 签到 今日免费 领红包部分的数据填充
    private void initSignin() {
        FruitImageText signin1 = new FruitImageText("领锦鲤红包，手慢无",R.drawable.lyb);
        meSignin.add(signin1);
        FruitImageText signin2 = new FruitImageText("今日免费",R.drawable.mf);
        meSignin.add(signin2);
        FruitImageText signin3 = new FruitImageText("签到  |  活动",R.drawable.siog_in);
        meSignin.add(signin3);
    }

    //书友圈的部分
    private void bookClub(View view){
        RecyclerView recyclerBookClub = view.findViewById(R.id.rv_main_syq);
        LinearLayoutManager linearBookClub = new LinearLayoutManager(getActivity());
        linearBookClub.setOrientation(RecyclerView.VERTICAL);
        recyclerBookClub.setLayoutManager(linearBookClub);
        MeAdapter meAdapterBookClub = new MeAdapter(meBookClub);
        recyclerBookClub.setAdapter(meAdapterBookClub);
        meAdapterBookClub.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position){
                    case 0:
                        Toast.makeText(getActivity(),"书友圈",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        initBookClub();
    }
    //书友圈的部分填充数据
    private void initBookClub() {
        FruitImageText bookClub1 = new FruitImageText("书友圈",R.drawable.me_friend);
        meBookClub.add(bookClub1);
    }

    //设置 帮助与反馈
    private void set(View view){
        RecyclerView recyclerSet= view.findViewById(R.id.rv_main_set);
        LinearLayoutManager linearSet = new LinearLayoutManager(getActivity());
        linearSet.setOrientation(RecyclerView.VERTICAL);
        recyclerSet.setLayoutManager(linearSet);
        MeAdapter meAdapterSet = new MeAdapter(meSet);
        recyclerSet.setAdapter(meAdapterSet);
        meAdapterSet.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(getActivity(), SeetingActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(getActivity(),"帮助与反馈",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        initSet();
    }
    //设置 帮助与反馈的数据填充
    private void initSet(){
        FruitImageText set1 = new FruitImageText("设置",R.drawable.me_set);
        meSet.add(set1);
        FruitImageText set2 = new FruitImageText("帮助与反馈",R.drawable.me_help);
        meSet.add(set2);
    }


    //初始化绑定布局
    private void init(View view) {
        me_zh = view.findViewById(R.id.me_zh);
        me_sj = view.findViewById(R.id.me_sj);
        me_sd = view.findViewById(R.id.me_sd);
        me_hd = view.findViewById(R.id.me_hd);
        meName = view.findViewById(R.id.Me_name);
        mAlarm = view.findViewById(R.id.title_img_alarm);

        btu_login = view.findViewById(R.id.btu_login);
        mAlarm.setOnClickListener(this);
        btu_login.setOnClickListener(this);
        me_zh.setOnClickListener(this);
        me_sj.setOnClickListener(this);
        me_sd.setOnClickListener(this);
        me_hd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            // 我的账户
            case R.id.me_zh:
                intent = new Intent(getActivity(), MyAccountActivity.class);
                startActivity(intent);
                break;
            // 书籍
            case R.id.me_sj:
                Toast.makeText(getActivity(), "我的书籍", Toast.LENGTH_SHORT).show();
                break;
            // 我的书单
            case R.id.me_sd:
                intent = new Intent(getActivity(), MyBookListActivity.class);
                startActivity(intent);
                break;
            // 互动
            case R.id.me_hd:
                Toast.makeText(getActivity(), "我的互动", Toast.LENGTH_SHORT).show();
                break;
            // 登陆
            case R.id.btu_login:
                intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            // 消息中心
            case R.id.title_img_alarm:
                intent = new Intent(getActivity(), MessageCenterActivity.class);
                startActivity(intent);
                break;
        }
    }

}
