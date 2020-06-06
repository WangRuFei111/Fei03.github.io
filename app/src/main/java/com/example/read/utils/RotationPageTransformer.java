package com.example.read.utils;

import android.graphics.Camera;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

public class RotationPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE=0.85f;//缩放大小
    private static final float MIN_ALPHA=0.5f;
    private static final float MAX_ROTATE=30;
    private Camera camera=new Camera();
    @Override
    public void transformPage(View page, float position) {
        float scaleFactor=Math.max(MIN_SCALE,1-Math.abs(position));//取缩放的值
        if (position<-1){

        }else if (position<0){//最右的时候是缩
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setRotationY(0);//垂直旋转度数为0
        }else if (position>=0&&position<1){//当前页不变化
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setRotationY(0);
        }
        else if (position>=1) {//最左的时候是缩
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setRotationY(0);
        }
    }
}
