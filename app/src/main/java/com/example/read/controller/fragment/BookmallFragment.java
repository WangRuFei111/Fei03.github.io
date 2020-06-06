package com.example.read.controller.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.read.R;
import com.example.read.controller.activity.AllChannelsActivity;
import com.example.read.controller.activity.ClassificationActivity;
import com.example.read.utils.HomeFragmentVPFragmentAdapter;
import com.example.read.zxing.android.CaptureActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

//书城的首页
public class BookmallFragment extends Fragment  implements View.OnClickListener {
    private ViewPager mViewPagerContent;
    private TabLayout mTavLayoutTiele;
    private ImageView mImageView;
    private TextView mTextView;
    private ImageButton mScan;
    private ArrayList<String> listtitle = new ArrayList<>();
    private ArrayList<Fragment> listfragments = new ArrayList<>();


    private static final String DECODED_CONTENT_KEY = "codedContent";
    private static final String DECODED_BITMAP_KEY = "codedBitmap";
    private static final int REQUEST_CODE_SCAN = 0x0000;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(),R.layout.activity_main_bookmall,null);
        mImageView = view.findViewById(R.id.bookmall_AllChannels);
        mTextView = view.findViewById(R.id.bookmall_title_txt);
        mScan = view.findViewById(R.id.scanBtn);
        mImageView.setOnClickListener(this);
        mTextView.setOnClickListener(this);
        mScan.setOnClickListener(this);
        dataInit(view);
        return view;
    }

    //TabLayout+viewPager的数据填充和设置
    private void dataInit(View view) {
        //找到控件
        mViewPagerContent = view.findViewById(R.id.bookmall_content_viewpager);
        mTavLayoutTiele = view.findViewById(R.id.bookmall_content_tab);
//      将标题添加到arraylist中
        listtitle.add("精选");
        listtitle.add("女生");
        listtitle.add("漫画");
        listtitle.add("精品课");
        listtitle.add("出版");
        listtitle.add("男生");
        listtitle.add("免费");
        listtitle.add("板栗");
//      遍历list集合，将tab添加到TabLayout中
        for (int i = 0; i < listtitle.size(); i++) {
            mTavLayoutTiele.addTab(mTavLayoutTiele.newTab().setText(listtitle.get(i)));
        }
//      将书城中头部页面中的各个板块添加进去
        BookmallChoicenessFragmgnt bookmallChoicenessFragmgnt = new BookmallChoicenessFragmgnt();//精选
        BookmallSchoolgirlFragment bookmallSchoolgirlFragment = new BookmallSchoolgirlFragment();//女生
        BookmallCartoonFragment bookmallCartoonFragment = new BookmallCartoonFragment();//漫画
        BookmallClassicalFragment bookmallClassicalFragment = new BookmallClassicalFragment();//精品课
        BookmallAppearFragment bookmallAppearFragment = new BookmallAppearFragment();//出版
        BookmallSchoolboyFragment bookmallSchoolboyFragment = new BookmallSchoolboyFragment();//男生
        BookmallGratisFragment bookmallGratisFragment = new BookmallGratisFragment();//免费
        BookmallChestnutFragment bookmallChestnutFragment = new BookmallChestnutFragment();//板栗
            listfragments.add(bookmallChoicenessFragmgnt);
            listfragments.add(bookmallSchoolgirlFragment);
            listfragments.add(bookmallCartoonFragment);
            listfragments.add(bookmallClassicalFragment);
            listfragments.add(bookmallAppearFragment);
            listfragments.add(bookmallSchoolboyFragment);
            listfragments.add(bookmallGratisFragment);
            listfragments.add(bookmallChestnutFragment);




        HomeFragmentVPFragmentAdapter mAdapter = new HomeFragmentVPFragmentAdapter(getFragmentManager(),listfragments,listtitle);
        mViewPagerContent.setOffscreenPageLimit(8);
        //给ViewPager设置适配器
        mViewPagerContent.setAdapter(mAdapter);
        //将TabLayout和ViewPager关联起来。
        mTavLayoutTiele.setupWithViewPager(mViewPagerContent);
        //给TabLayout设置适配器
        mTavLayoutTiele.setTabsFromPagerAdapter(mAdapter);
        mTavLayoutTiele.getTabAt(1).select();
    }

    @Override
    public void onClick(View v) {
        Intent intent =null;
        switch (v.getId()){
            case R.id.bookmall_title_txt:
                intent = new Intent(getActivity(), ClassificationActivity.class);
                startActivity(intent);
                break;
            case R.id.bookmall_AllChannels:
                 intent = new Intent(getActivity(), AllChannelsActivity.class);
                startActivity(intent);
                break;
            case R.id.scanBtn:
                //动态权限申请
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, 1);
                } else {
                    goScan();
                }
                break;
        }
    }

    /**
     * 跳转到扫码界面扫码
     */
    private void goScan(){
        Intent intent = new Intent(getActivity(), CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE_SCAN);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    goScan();
                } else {
                    Toast.makeText(getActivity(), "你拒绝了权限申请，可能无法打开相机扫码哟！", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                //返回的文本内容
                String content = data.getStringExtra(DECODED_CONTENT_KEY);
                //返回的BitMap图像
                Bitmap bitmap = data.getParcelableExtra(DECODED_BITMAP_KEY);
                Toast.makeText(getActivity(), "你扫描到的内容是："+content, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
