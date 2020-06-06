package com.example.read.controller.popupWindow;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.read.R;

public class SharePopupWindow extends PopupWindow {
    private View mView;

    public SharePopupWindow(Activity context, View.OnClickListener itemsOnClicks) {
        super(context);
        initView(context, itemsOnClicks);
    }

    private void initView(final Activity context, View.OnClickListener itemsOnClicks) {
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = mInflater.inflate(R.layout.share_linearlayout, null);
        LinearLayout weiXFriend =  mView.findViewById(R.id.weixinghaoyou);
        LinearLayout friendster =  mView.findViewById(R.id.pengyouquan);
        LinearLayout QQFriend =  mView.findViewById(R.id.qqhaoyou);
        LinearLayout QQZone =  mView.findViewById(R.id.qqkongjian);
        LinearLayout more =  mView.findViewById(R.id.gengd);
        TextView canaleTv =  mView.findViewById(R.id.share_cancle);
        canaleTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //销毁弹出框
                dismiss();
                backgroundAlpha(context, 1f);
            }
        });
        //设置按钮监听
        weiXFriend.setOnClickListener(itemsOnClicks);
        friendster.setOnClickListener(itemsOnClicks);
        QQFriend.setOnClickListener(itemsOnClicks);
        QQZone.setOnClickListener(itemsOnClicks);
        more.setOnClickListener(itemsOnClicks);
        //设置SelectPicPopupWindow的View
        this.setContentView(mView);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(WindowManager.LayoutParams.FILL_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        //设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置PopupWindow可触摸
        this.setTouchable(true);
        //设置非PopupWindow区域是否可触摸
//    this.setOutsideTouchable(false);
        //设置SelectPicPopupWindow弹出窗体动画效果
//    this.setAnimationStyle(R.style.select_anim);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x00000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        backgroundAlpha(context, 0.5f);//0.0-1.0
        this.setOnDismissListener(new OnDismissListener() {

            @Override
            public void onDismiss() {
                // TODO Auto-generated method stub
                backgroundAlpha(context, 1f);
            }
        });
    }


    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(Activity context, float bgAlpha) {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        context.getWindow().setAttributes(lp);
    }

}
